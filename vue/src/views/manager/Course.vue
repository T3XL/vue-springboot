<template>
  <div>
    <div class="card" style="margin-bottom: 10px">
      <el-input style="width: 260px; margin-right: 10px" v-model="data.name" placeholder="请输入查询课程名称"
                :prefix-icon="Search"/>
      <el-input style="width: 260px;" v-model="data.courseno" placeholder="请输入查询课程编号" :prefix-icon="Search"/>
      <el-button style="margin-left: 10px" type="primary" @click="load">查询</el-button>
      <el-button type="info" @click="reset">重置</el-button>
    </div>
    <div class="card" style="margin-bottom: 10px">
      <el-button type="primary" @click="add">新增</el-button>
    </div>

    <div class="card" style="margin-bottom: 10px">
      <el-table :data="data.tableData" style="width: 100%">
        <el-table-column prop="courseno" label="课程编号"></el-table-column>
        <el-table-column prop="coursename" label="课程名称"></el-table-column>
        <el-table-column prop="credit" label="学分"></el-table-column>
        <el-table-column prop="credithour" label="学时"></el-table-column>
        <el-table-column prop="coursetype" label="课程类型"></el-table-column>
        <el-table-column prop="experimenttype" label="实验方式"></el-table-column>
        <el-table-column>
          <template #default="scope">
            <el-button type="primary" size="small" @click="edit(scope.row)">编辑</el-button>
            <el-button type="danger" size="small" @click="del(scope.row.courseno)">删除</el-button>
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
        <el-form-item label="课程名称" label-width="100px">
          <el-input v-model="data.form.coursename" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="课程编号" label-width="100px">
          <el-input v-model="data.form.courseno" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="学分" label-width="100px">
          <el-input v-model="data.form.credit" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="学时" label-width="100px">
          <el-select v-model="data.form.credithour" placeholder="请选择学时" style="width: 100%">
            <el-option label="32" value="32"></el-option>
            <el-option label="48" value="48"></el-option>
            <el-option label="64" value="64"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="课程类型" label-width="100px">
          <el-input v-model="data.form.coursetype" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="实验方式" label-width="100px">
          <el-input v-model="data.form.experimenttype" autocomplete="off"></el-input>
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
import {reactive} from "vue";
import {Search} from '@element-plus/icons-vue';
import request from "../../utils/request";
import {ElMessage, ElMessageBox} from "element-plus";

const data = reactive({
  name: '',
  courseno: '',
  tableData: [],
  total: 0,
  page: 1,
  size: 11,
  dialogVisible: false,
  form: {},
  flag: false
})
const load = () => {
  request.get('/course/courselist', {
    params: {
      page: data.page,
      size: data.size,
      coursename: data.name,
      courseno: data.courseno
    }
  }).then(res => {
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
  load();
}
const add = () => {
  data.flag = false;
  data.form = {};
  data.dialogVisible = true;
}
const save = () => {
  request.request({
    url: data.flag ? '/course/updatecourse' : '/course/addcourse',
    method: data.flag ? 'PUT' : 'POST',
    data: data.form,
  }).then(res => {
    if (res.code === '200') {
      data.dialogVisible = false;
      load();
      ElMessage.success(res.msg);
    } else {
      ElMessage.error(res.msg);
    }
  })
}
const edit = (row) => {
  data.flag = true;
  data.form = row;
  data.dialogVisible = true;
}
const del = (courseno) => {
  ElMessageBox.confirm('确认删除该课程吗？', '提示', {type: 'warning'}).then(() => {
    request.delete('/course/deletecourse/' + courseno).then(res => {
      if (res.code === '200') {
        load();
        ElMessage.success(res.msg);
      } else {
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

