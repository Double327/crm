<template>
  <div>
    <template>
      <el-main>
        <el-button @click="addDate" icon="el-icon-circle-plus" type="primary">增加</el-button>
        <el-button @click="dowloadData" type="primary">下载列表</el-button>
        <el-autocomplete
            class="right-search"
            v-model="state"
            :fetch-suggestions="querySearchAsync"
            placeholder="请输入客户名称"
            @select="handleSelect"
        ></el-autocomplete>
        <el-button @click="searchData" icon="el-icon-search" type="primary">搜索</el-button>
      </el-main>
      <el-table
          ref="singleTable"
          :data="tableData"
          highlight-current-row
          @current-change="handleCurrentChange"
          style="width: 100%"
          border>
        <el-table-column
            align="center"
            type="index"
            label="编号"
            width="60">
        </el-table-column>
        <el-table-column
            sortable
            align="center"
            property="name"
            label="客户名称"
            width="120">
        </el-table-column>
        <el-table-column
            sortable
            property="contact"
            label="联系人"
            align="center">
        </el-table-column>
        <el-table-column
            property="telephone"
            label="联系人电话"
            align="center">
        </el-table-column>
        <el-table-column
          property="content"
          label="计划内容"
          align="center"
          width="120">
        </el-table-column>
        <el-table-column
            property="actiondate"
            label="计划实施时间"
            align="center">
        </el-table-column>
        <el-table-column
            property="result"
            label="结果"
            align="center"
            width='120'>
          <template slot-scope="scope">
            <el-button
                size="mini"
                type="success"
                @click="handleEdit(scope.$index, scope.row)">开发成功
            </el-button>
          </template>
        </el-table-column>
        <el-table-column
            property="operation"
            label="操作"
            align="center"
            width="360">
          <template>
            <el-button
                size="mini"
                type="primary" plain>执行开发
            </el-button>
            <el-button
                size="mini"
                type="success" plain>开发成功
            </el-button>
            <el-button
                size="mini"
                type="danger" plain>开发失败
            </el-button>
          </template>
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
  name: "CustomDevelopPlainView",
  data() {
    return {
      tableData: [{
        name:'李四',
        contact:'王五',
        telephone:'11111111111',
        content:'馒头',
        actiondate:'2018-03-05 11:54:14',
      }, {
        name:'李四2',
        contact:'王五2',
        telephone:'22222222222',
        content:'馒头',
        actiondate:'2018-03-05 11:54:14',
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
