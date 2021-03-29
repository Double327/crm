<template>
  <div>
    <el-table
        :data="tableData"
        border
        style="width: 100%"
    >
      <el-table-column
          align="center"
          prop="id"
          label="ID"
          width="180"
      >
      </el-table-column>
      <el-table-column
          align="center"
          prop="name"
          label="角色名"
          width="180"
      >
      </el-table-column>
      <el-table-column
          align="center"
          prop="description"
          label="描述"
          width="180"
      >
      </el-table-column>
      <el-table-column
          align="center"
          prop="sort"
          label="排序"
          width="180"
      >
      </el-table-column>
      <el-table-column
          align="center"
          prop="status"
          label="禁用"
          width="180"
      >
        <template slot-scope="scope">
          <el-switch v-bind:value="scope"></el-switch>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import {getRoleList} from "@/api/role";

export default {
  name: "RoleView",
  mounted() {
    getRoleList().then(res => {
      this.tableData = res;
    })
  },
  data() {
    return {
      tableData: []
    }
  }
}
</script>

<style scoped>

</style>
