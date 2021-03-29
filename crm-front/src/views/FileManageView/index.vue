<template>
  <div>
    <template>
      <el-main>
        <el-button @click="addDate" icon="el-icon-circle-plus" type="primary">选择文件上传</el-button>
        <el-button @click="dowloadData" icon="el-icon-delete" type="primary">删除选中文件</el-button>
      </el-main>
      <el-table
          ref="singleTable"
          :data="tableData"
          highlight-current-row
          @current-change="handleCurrentChange"
          style="width: 100%"
          border>
        <el-table-column
            property="filename"
            label="文件名"
            align="center"
            width="240">
        </el-table-column>
        <el-table-column
            property="type"
            label="类型"
            align="center"
            width="240">
        </el-table-column>
        <el-table-column
            property="size"
            label="大小"
            align="center"
            width="360">
        </el-table-column>
        <el-table-column
            property="user"
            label="上传用户"
            align="center"
            width="360">
        </el-table-column>
        <el-table-column
            property="time"
            label="上传时间"
            align="center"
            width="360">
        </el-table-column>
        <el-table-column
            property="state"
            label="状态"
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
export default {
  name: "FileManageView",
  data() {
    return {
      tableData: [{
        filename:'项目开发需求.txt',
        type:'.txt',
        size:'3.39kb',
        user:'admin',
        time:'2018-03-05 11:54:14',
        state:'上传成功',
      }, {
        filename:'项目开发需求.txt',
        type:'.txt',
        size:'3.39kb',
        user:'admin',
        time:'2018-03-05 11:54:14',
        state:'上传成功',
      }, {
        filename:'项目开发需求.txt',
        type:'.txt',
        size:'3.39kb',
        user:'admin',
        time:'2018-03-05 11:54:14',
        state:'上传成功',
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
