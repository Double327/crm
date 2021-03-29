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
            property="profile"
            label="概要"
            align="center"
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
            property="creatime"
            label="创建时间"
            align="center">
        </el-table-column>
        <el-table-column
            property="state"
            label="状态"
            align="center"
            sortable
            width="80">
          <el-tag type="info">未分配</el-tag>
        </el-table-column>
        <el-table-column
            property="operation"
            label="操作"
            align="center">
          <template slot-scope="scope">
            <el-button
                size="mini"
                type="info"
                @click="handleEdit(scope.$index, scope.row)">指派
            </el-button>
            <el-button size="mini"
                       type="primary"
                       icon="el-icon-edit"
                       circle></el-button>
            <el-button
                size="mini"
                type="danger"
                icon="el-icon-delete"
                circle></el-button>
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
  name: "CustomManageView",
  data() {
    return {
      tableData: [{
        date: '2016-05-02',
        name: '王小虎1',
        address: '上海市普陀区金沙江路 1518 弄',
        telephone: 'xxxxxxxxxx',
        fax: 'faxxxxxxxxx',
        coustmerlevel: '大客户',
        customersatisfaction: '五星',
        customercredit: '三星',
        coustomermanager: '20经理',
      }, {
        date: '2016-05-02',
        name: '王小虎2',
        address: '上海市普陀区金沙江路 1518 弄',
        telephone: 'xxxxxxxxxx',
        fax: 'faxxxxxxxxx',
        coustmerlevel: '各做伙伴',
        customersatisfaction: '三星',
        customercredit: '三星',
        coustomermanager: '39经理',
      }, {
        date: '2016-05-02',
        name: '王小虎3',
        address: '上海市普陀区金沙江路 1518 弄',
        telephone: 'xxxxxxxxxx',
        fax: 'faxxxxxxxxx',
        coustmerlevel: '',
        customersatisfaction: '',
        customercredit: '',
        coustomermanager: '',
      }, {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄',
        telephone: 'xxxxxxxxxx',
        fax: 'faxxxxxxxxx',
        coustmerlevel: '',
        customersatisfaction: '',
        customercredit: '',
        coustomermanager: '',
      }, {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄',
        telephone: 'xxxxxxxxxx',
        fax: 'faxxxxxxxxx',
        coustmerlevel: '',
        customersatisfaction: '',
        customercredit: '',
        coustomermanager: '',
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
