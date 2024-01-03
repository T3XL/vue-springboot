<template>
  <div>
    <div class="card" style="margin-bottom: 10px">
      <el-input style="width: 260px; margin-right: 10px"  v-model="data.name" placeholder="请输入查询实验名称" :prefix-icon="Search"/>
      <el-input style="width: 260px; margin-right: 10px"  v-model="data.courseno" placeholder="请输入查询课程编号" :prefix-icon="Search"/>
      <el-input style="width: 260px;"  v-model="data.itemno" placeholder="请输入查询实验编号" :prefix-icon="Search"/>
      <el-button style="margin-left: 10px" type="primary" @click="load">查询</el-button>
      <el-button type="info" @click="reset">重置</el-button>
    </div>
    <div class="card" style="margin-bottom: 10px">
      <el-button type="primary" @click="add">新增</el-button>
    </div>

    <div class="card" style="margin-bottom: 10px">
      <el-table :data="data.tableData" style="width: 100%">
        <el-table-column prop="itemno" label="实验项目编号"></el-table-column>
        <el-table-column prop="itemname" label="实验项目名称"></el-table-column>
        <el-table-column prop="courseno" label="课程编号"></el-table-column>
        <el-table-column prop="itemhour" label="实验学时"></el-table-column>
        <el-table-column prop="itemtype" label="实验类型"></el-table-column>
        <el-table-column prop="iscompulsory" label="是否必做"></el-table-column>
        <el-table-column>
          <template #default="scope">
            <el-button type="primary" size="small" @click="edit(scope.row)">编辑</el-button>
            <el-button type="danger" size="small" @click="del(scope.row.itemno)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="card">
      <el-pagination v-model:current-page="data.page" v-model:page-size="data.size"
                     @current-change="handleCurrentChange"
                     background layout="prev, pager, next" :total="data.total"></el-pagination>
    </div>

    <el-dialog v-model="data.dialogVisible" title="课程信息">
      <el-form :model="data.form" label-width="80px" style="padding-right: 30px">
        <el-form-item label="实验名称" label-width="100px">
          <el-input v-model="data.form.itemname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="实验编号" label-width="100px">
          <el-input v-model="data.form.itemno" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="课程编号" label-width="100px">
          <el-input v-model="data.form.courseno" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="实验学时" label-width="100px">
          <el-input v-model="data.form.itemhour" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="实验类型" label-width="100px">
          <el-input v-model="data.form.itemtype" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否必做" label-width="100px">
          <el-input v-model="data.form.iscompulsory" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button type="primary" @click="save">保存</el-button>
        <el-button @click="data.dialogVisible = false">取消</el-button>
      </template>
    </el-dialog>
  </div>
</template>
<script setup>
import { reactive } from "vue";
import { Search } from '@element-plus/icons-vue';
import request from "../../utils/request";
import {ElMessage, ElMessageBox} from "element-plus";
const data = reactive({
  name: '',
  itemno: '',
  courseno: '',
  tableData:[],
  total: 0,
  page: 1,
  size: 11,
  dialogVisible: false,
  form: {},
  flag: false
})
const load = () => {
  request.get('/experiment/experimentlist',{
    params:{
      page:data.page,
      size:data.size,
      itemname:data.name,
      itemno:data.itemno,
      courseno:data.courseno,
    }
  }).then(res=>{
    data.tableData = res.data?.list || [];
    data.total = res.data?.total || 0;
  })
}
load()
const handleCurrentChange = () => {
  load();
}
const reset = () => {
  data.name = '';
  data.courseno = '';
  data.itemno = '';
  load();
}
const add = () => {
  data.flag = false;
  data.form={};
  data.dialogVisible = true;
}
const save = () => {
  request.request({
    url: data.flag ? '/experiment/updateexperiment' : '/experiment/addexperiment',
    method: data.flag ? 'PUT' : 'POST',
    data: data.form,
  }).then(res=>{
    if(res.code === '200'){
      data.dialogVisible = false;
      load();
      ElMessage.success(res.msg);
    }else {
      ElMessage.error(res.msg);
    }
  })
}
const edit = (row) => {
  data.form = row;
  data.flag = true;
  data.dialogVisible = true;
}
const del = (itemno) => {
  ElMessageBox.confirm('确认删除该实验吗？', '提示', {type: 'warning'}).then(() => {
    request.delete('/experiment/deleteexperiment/'+itemno).then(res=>{
      if(res.code === '200'){
        load();
        ElMessage.success(res.msg);
      }else {
        ElMessage.error(res.msg);
      }
    })
  }).catch(() => {
    ElMessage({
      type: 'info',
      message: '取消删除'
    });
  });

}
</script>

