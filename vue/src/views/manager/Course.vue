<template>
  <div>
    <div class="card" style="margin-bottom: 10px">
      <el-input style="width: 260px; margin-right: 10px"  v-model="data.name" placeholder="请输入查询课程名称" :prefix-icon="Search"/>
      <el-input style="width: 260px;"  v-model="data.courseno" placeholder="请输入查询课程编号" :prefix-icon="Search"/>
      <el-button style="margin-left: 10px" type="primary" @click="load">查询</el-button>
      <el-button type="info" @click="reset">重置</el-button>
    </div>
    <div class="card" style="margin-bottom: 10px">
      <el-button type="primary">新增</el-button>
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
            <el-button type="primary" size="small">编辑</el-button>
            <el-button type="danger" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="card">
      <el-pagination v-model:current-page="data.page" v-model:page-size="data.size"
                     @current-change="handleCurrentChange"
                     background layout="prev, pager, next" :total="data.total"></el-pagination>
    </div>
  </div>
</template>
<script setup>
import { reactive } from "vue";
import { Search } from '@element-plus/icons-vue';
import request from "../../utils/request";
const data = reactive({
    name: '',
    courseno: '',
    tableData:[],
    total: 0,
    page: 1,
    size: 11,
})
const load = () => {
  request.get('/course/courselist',{
    params:{
      page:data.page,
      size:data.size,
      coursename:data.name,
      courseno:data.courseno
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
  load();
}
</script>

