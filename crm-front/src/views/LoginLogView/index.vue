<template>
  <div>
    <template>
      <el-main>
        <el-button @click="dowloadData" icon="el-icon-delete" type="primary">清除过滤</el-button>
      </el-main>
      <el-table
          ref="singleTable"
          :data="tableData"
          highlight-current-row
          @current-change="handleCurrentChange"
          style="width: 100%"
          border>
        <el-table-column
            type="index"
            label="编号"
            align="center"
            width="120">
        </el-table-column>
        <el-table-column
            type="selector"
            label="方法名"
            align="center"
            width="180">
        </el-table-column>
        <el-table-column
            property="lineandclass"
            label="行+类名"
            align="center"
            width="360">
        </el-table-column>
        <el-table-column
            property="log"
            label="日志信息（登录名+【角色或密码】+状态）"
            align="center">
        </el-table-column>
        <el-table-column
            property="time"
            label="时间"
            align="center"
            width="360">
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
export default {
  name: "LoginLogView",
  data() {
    return {
      tableData: [{
        index:'1',
        selector:'login',
        lineandclass:'28,com.maizhe.controller.LoginController',
        log:'admin【admin,TD manager,product,test】登陆成功',
        time:'2018-03-05 11:54:14',
      }, {
        index:'2',
        selector:'login',
        lineandclass:'3.39kb',
        log:'admin',
        time:'2018-03-05 11:54:14',
      }, {
        index:'3',
        selector:'login',
        lineandclass:'3.39kb',
        log:'admin',
        time:'2018-03-05 11:54:14',
      }],
      currentRow: null
    }
  },

  methods: {
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
.right-search{
  margin-left: 1360px;
}
</style>
