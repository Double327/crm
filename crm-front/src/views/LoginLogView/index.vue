<template>
  <div>
    <template>
      <el-main>
        <el-button type="primary">登录日志管理</el-button>
      </el-main>
      <el-table
          ref="singleTable"
          :data="tableData"
          v-loading="loading"
          highlight-current-row
          @current-change="handleCurrentChange"
          style="width: 100%"
          border>
        <el-table-column
            type="index"
            label="编号"
            property="id"
            align="center"
            width="120">
        </el-table-column>
        <el-table-column
            type="selector"
            label="姓名"
            property="username"
            align="center"
            width="180">
        </el-table-column>
        <el-table-column
            property="loginip"
            label="ip地址"
            align="center"
            width="360">
        </el-table-column>
        <el-table-column
            property="logindate"
            label="登录日期"
            align="center">
        </el-table-column>

      </el-table>
      <div class="block">
        <span class="demonstration"></span>
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage4"
            :page-sizes="[5, 10, 15]"
            :page-size="10"
            layout="total, sizes, prev, pager, next, jumper"
            :total="400">
        </el-pagination>
      </div>
    </template>
  </div>
</template>

<script>
import {getLog} from "@/api/log";

export default {
  name: "LoginLogView",
  data() {
    return {
      tableData: [],
      currentRow: null
    }
  },
  mounted() {
    this.loading=true
    this.initTable()
  },
  methods: {
    initTable(){
      getLog().then(res => {
        console.log(res)
        if(res){
          this.loading=false
          this.tableData = res.data
        }
      })
    },
    setCurrent(row) {
      this.$refs.singleTable.setCurrentRow(row);
    },
    handleCurrentChange(val) {
      this.currentRow = val;
    }
  }
}

</script>


<style scoped>

</style>
