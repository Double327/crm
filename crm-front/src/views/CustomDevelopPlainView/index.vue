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
            <el-button type="primary"
                class="font-awesome"
                @click="start(scope.row)" circle
            >&#xf04b;</el-button>执行开发
            <el-button type="success"
                icon="el-icon-check"
                @click="success(scope.row)"
                 circle></el-button>开发成功
            <el-button type="danger"
                 icon="el-icon-close"
                 @click="lose(scope.row)"
                 circle></el-button>开发失败
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
        if(res) {
          this.tableData = res.data
          console.log("status"+this.data)
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
@font-face {
  font-family: 'FontAwesome';
  src: url('../../assets/style/font-awesome-4.7.0/fonts/fontawesome-webfont.eot?v=4.7.0');
  src: url('../../assets/style/font-awesome-4.7.0/fonts/fontawesome-webfont.eot?#iefix&v=4.7.0') format('embedded-opentype'), url('../../assets/style/font-awesome-4.7.0/fonts/fontawesome-webfont.woff2?v=4.7.0') format('woff2'), url('../../assets/style/font-awesome-4.7.0/fonts/fontawesome-webfont.woff?v=4.7.0') format('woff'), url('../../assets/style/font-awesome-4.7.0/fonts/fontawesome-webfont.ttf?v=4.7.0') format('truetype'), url('../../assets/style/font-awesome-4.7.0/fonts/fontawesome-webfont.svg?v=4.7.0#fontawesomeregular') format('svg');
  font-weight: normal;
  font-style: normal;
}
.font-awesome{
  width: 20px;
  padding-bottom: 25px;
  padding-right: 20px;
  height: 20px;
  font-family: FontAwesome;
}
.right-search{
  margin-left: 1360px;
}
</style>
