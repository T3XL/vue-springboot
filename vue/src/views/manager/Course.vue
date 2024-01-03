<template>
  <div>
    <div class="card" style="margin-bottom: 10px">
      <el-input style="width: 260px" v-model="data.name" placeholder="请输入查询课程名称" :prefix-icon="Search"/>
      <el-button style="margin-left: 10px" type="primary" @click="search">查询</el-button>
      <el-button type="info" @click="reset">重置</el-button>
    </div>
    <div class="card" style="margin-bottom: 10px">
      <el-button type="primary">新增</el-button>
    </div>

    <div>
      <el-table :data="data.tableData" style="width: 100%">
        <el-table-column prop="name" label="课程名称"></el-table-column>
        <el-table-column prop="teacher" label="授课老师"></el-table-column>
        <el-table-column prop="time" label="上课时间"></el-table-column>
      </el-table>

    </div>

  </div>
</template>
<script setup>
import { reactive } from "vue";
import { Search } from '@element-plus/icons-vue';
const data = reactive({
    name: '',
    tableData:[
        {
          name: '语文',
          teacher: '李老师',
          time: '10:00-12:00'
        },
        {
          name: '数学',
          teacher: '王老师',
          time: '12:00-14:00'
        },
        {
          name: '英语',
          teacher: '赵老师',
          time: '14:00-16:00'
        }
    ]

})
const search = () => {
}
const reset = () => {
}
</script>

