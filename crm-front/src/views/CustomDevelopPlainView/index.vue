<template>
  <div>
    <template>
      <el-main>
      </el-main>
      <el-table
          ref="singleTable"
          :data="tableData"
          v-loading="tableLoading"
          highlight-current-row
          @current-change="handleCurrentChange"
          style="width: 100%"
          border>
        <el-table-column
            align="center"
            property="id"
            label="编号"
            width="60">
        </el-table-column>
        <el-table-column
            sortable
            align="center"
            property="salesChanceId"
            label="营销机会编号"
            width="120">
        </el-table-column>
        <el-table-column
            sortable
            property="date"
            label="日期"
            align="center">
        </el-table-column>
        <el-table-column
            property="planContent"
            label="计划内容"
            align="center">
        </el-table-column>
        <el-table-column
          property="status"
          label="结果"
          align="center"
          width="120">
        </el-table-column>
        <el-table-column
            property="operation"
            label="操作"
            align="center"
            width="360">
          <template slot-scope="scope">
            <el-button
                size="mini"
                type="primary" @click="start(scope.row)" plain>执行开发
            </el-button>
            <el-button
                size="mini"
                type="success" @click="success(scope.row)" plain>开发成功
            </el-button>
            <el-button
                size="mini"
                type="danger" @click="lose(scope.row)" plain>开发失败
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="block">
        <span class="demonstration"></span>
        <el-pagination
            @current-change="handleCurrentChange"
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
import {findAllUser, lose, start, success} from '@/api/sales'
export default {
  name: "CustomDevelopPlainView",
  data() {
    return {
      tableData: [],
      currentRow: null
    }
  },
  mounted: function() {
    this.tableLoading = true
    this.loadUserList()

  },
  methods: {
    loadUserList() {
      findAllUser().then(res => {
        this.tableLoading = false
        console.log("res的值为:"+res)
        if(res) {
          this.tableData = res.data
        }

      })
    },
    setCurrent(row) {
      this.$refs.singleTable.setCurrentRow(row);
    },
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    start(id){
      start(id.id).then(res => {
        if(res){
          id.status = '执行中'
          let aData = new Date();
          let time = this.value =
              aData.getFullYear() + "-" + (aData.getMonth() + 1) + "-" + aData.getDate()+" "+aData.getHours()+":"+aData.getMinutes()+":"+aData.getSeconds();
          id.date = ''+time
        }
      })
    },
    lose(id){
      lose(id.id).then(res => {
        if(res){
          id.status = '开发失败'
          let aData = new Date();
          let time = this.value =
              aData.getFullYear() + "-" + (aData.getMonth() + 1) + "-" + aData.getDate()+" "+aData.getHours()+":"+aData.getMinutes()+":"+aData.getSeconds();
          id.date = ''+time
        }
      })
    },
    success(id){
      success(id.id).then(res => {
        if(res){
          id.status = '开发成功'
          let aData = new Date();
          let time = this.value =
              aData.getFullYear() + "-" + (aData.getMonth() + 1) + "-" + aData.getDate()+" "+aData.getHours()+":"+aData.getMinutes()+":"+aData.getSeconds();
          id.date = ''+time
        }
      })
    }
  }
}

</script>


<style scoped>

.right-search{
  margin-left: 1360px;
}
</style>
