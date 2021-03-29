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
            width="240">
        </el-table-column>
        <el-table-column
            property="reason"
            label="流失原因"
            align="center"
            width="240">
        </el-table-column>
        <el-table-column
            property="lostdate"
            label="流失时间"
            align="center"
            width="240">
        </el-table-column>
        <el-table-column
            property="project"
            label="暂缓流失计划"
            align="center"
            width="240">
        </el-table-column>
        <el-table-column
            property="status"
            label="流失状态"
            align="center"
            width="180"
        >
          <template slot-scope="scope">
            <el-button
                disabled
                size="mini"
                type="warning"
                @click="handleEdit(scope.$index, scope.row)">暂缓流失
            </el-button>
          </template>

        </el-table-column>
        <el-table-column
            property="lastdate"
            label="最后订单时间"
            align="center"
            width="240">
        </el-table-column>
        <el-table-column
            property="operation"
            label="操作"
            align="center">
          <template>
            <el-button
                size="mini"
                type="warning" plain>暂缓计划
            </el-button>
            <el-button
                size="mini"
                type="warning" plain>确认流失
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
  name: "CustomDrainsView",
  data() {
    return {
      tableData: [{
        name: '张三1',
        reason:'长期不联系',
        lostdate: '2018-02-022 18:27:54',
        project: '',
        lastdate:'2017-12-27 18:28:17',
      }, {
        name: '张三2',
        reason:'找了隔壁老王',
        lostdate: '2018-02-025 23:50:29',
        project: '',
        lastdate:'2017-12-27 18:28:17',
      }, {
        name: '张三3',
        reason:'隔壁老王来了',
        lostdate: '2018-02-022 18:27:54',
        project: '',
        lastdate:'2017-12-27 18:28:17',
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
