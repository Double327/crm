<template>
  <div class="app-container">
    <el-form :inline="true" label-width="68px">
      <el-form-item label="用户名称">
        <el-input v-model="queryParams.userName" placeholder="请输入用户名称" clearable size="small"/>
      </el-form-item>
      <el-form-item label="手机号码">
        <el-input v-model="queryParams.phone" placeholder="请输入手机号码" clearable size="small"/>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="queryParams.status" placeholder="用户状态" clearable size="small">
          <el-option value="1"/>
          <el-option value="2"/>
          <el-option value="3"/>
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker size="small" value-format="yyyy-MM-dd"
                        type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini">搜索
        </el-button>
        <el-button icon="el-icon-refresh" size="mini">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" icon="el-icon-plus" size="mini"
                   @click="handleAdd">新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" icon="el-icon-edit" size="mini" :disabled="single"
                   @click="handleUpdate(null)">修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" icon="el-icon-delete" size="mini" :loading="delLoading" :disabled="multiple">删除
        </el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="list">
      <el-table-column type="selection"/>
      <el-table-column label="登录名称" prop="loginName"/>
      <el-table-column label="真实姓名" prop="realName"/>
      <el-table-column label="手机号码" prop="phone"/>
      <el-table-column label="部门" prop="organizationName"/>
      <el-table-column label="出生日期" prop="birth"/>
      <el-table-column label="状态">
        <template slot-scope="scope">
          <el-switch v-model="scope.row.status" active-value="0" inactive-value="1"
                     @change="handleStatusChange(scope.row)"/>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" prop="createTime" width="160">
        <template slot-scope="scope">
          <span>{{ scope.row.createTime }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="180" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit"
                     @click="handleUpdate(scope.row)">修改
          </el-button>
          <el-popover :ref="scope.row.id" placement="top" width="180">
            <p>确定删除本条数据吗？</p>
            <div style="text-align: right; margin: 0">
              <el-button size="mini" type="text" @click="$refs[scope.row.id].doClose()">取消
              </el-button>
              <el-button :loading="loading" type="primary" size="mini" @click="handleSubDelete(scope.row.id)">确定
              </el-button>
            </div>
            <el-button slot="reference" type="text" icon="el-icon-delete" size="mini">删除
            </el-button>
          </el-popover>
          <el-button size="mini" type="text" icon="el-icon-key"
                     @click="handleResetPwd(scope.row)">重置
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加或修改用户对话框 -->
    <el-dialog :close-on-click-modal="false" :title="title" :visible.sync="open" width="600px">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="用户昵称" prop="nickName">
              <el-input v-model="form.nickName" placeholder="请输入用户昵称"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="手机号码" prop="phone">
              <el-input v-model="form.phone" placeholder="请输入手机号码" maxlength="11"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="邮箱" prop="email">
              <el-input v-model="form.email" placeholder="请输入邮箱" maxlength="50"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="用户名称" prop="userName">
              <el-input v-model="form.userName" placeholder="请输入用户名称"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item v-if="form.id === undefined" label="用户密码" prop="password">
              <el-input v-model="form.password" placeholder="请输入用户密码" type="password"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="用户性别">
              <el-select v-model="form.sex" placeholder="请选择">
                <el-option
                    v-for="dict in sexOptions"
                    :key="dict.dictValue"
                    :label="dict.dictLabel"
                    :value="dict.dictValue"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="状态">
              <el-radio-group v-model="form.status">
                <el-radio
                    v-for="dict in statusOptions"
                    :key="dict.dictValue"
                    :label="dict.dictValue"
                >{{ dict.dictLabel }}
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="角色">
              <el-select v-model="form.roleIds" multiple placeholder="请选择">
                <el-option
                    v-for="item in roleOptions"
                    :key="item.id"
                    :label="item.roleName"
                    :value="item.id"
                    :disabled="item.status === 1"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注">
              <el-input v-model="form.remark" type="textarea" placeholder="请输入内容"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button>取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {findAllUser} from "@/api/user";

export default {
  name: 'UserView',
  data() {
    return {
      // 对话框标题
      title: '',
      formReset: {},
      // 表单参数
      form: {},
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderByColumn: "createTime",
        isAsc: "desc",
        //此处和具体的组件合并后可以设置查询参数
        userName: undefined,
        phone: undefined,
        status: undefined,
      },
      list: [],
      // 默认密码
      initPassword: "123456",
      // 状态数据字典
      statusOptions: [],
      // 性别状态字典
      sexOptions: [],
      // 角色选项
      roleOptions: [],
      defaultProps: {
        children: "children",
        label: "label"
      },
      // 表单校验
      rules: {
        userName: [
          {required: true, message: "用户名称不能为空", trigger: "blur"}
        ],
        nickName: [
          {required: true, message: "用户昵称不能为空", trigger: "blur"}
        ],
        password: [
          {required: true, message: "用户密码不能为空", trigger: "blur"}
        ],
        email: [
          {
            type: "email",
            message: "'请输入正确的邮箱地址",
            trigger: ["blur", "change"]
          }
        ],
        phone: [
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur"
          }
        ]
      }
    };
  },
  created() {
    this.$nextTick(() => {
      this.init()
    });
    findAllUser().then(res => {
      console.log(res);
      this.list = res.rows;
    })
  },
  methods: {
    beforeInit() {
      this.base = '/system/user';
      this.modelName = '用户';
      return true
    },
    // 筛选节点
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    /** 查询角色列表 */
    getRoles() {

    },
    // 用户状态修改
    handleStatusChange(row) {
      let text = row.status === "0" ? "启用" : "停用";
      this.$confirm('确认要"' + text + '""' + row.userName + '"用户吗?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {

      }).then((response) => {
        if (response.code === 200) {
          this.msgSuccess(text + "成功");
        } else {
          this.msgError(text + "失败");
        }
      }).catch(function () {
        row.status = row.status === "0" ? "1" : "0";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.getRoles();
      this.open = true;
      this.title = "添加用户";
      this.form.password = this.initPassword;
    },
    /** 修改按钮操作 */
    handleUpdate() {
      this.reset();
      this.getRoles();
    },
    /** 重置密码按钮操作 */
    handleResetPwd(row) {
      this.$prompt('请输入"' + row.userName + '"的新密码', "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      }).then(() => {
        console.log()
      }).catch(() => {
      });
    },
    /** 提交按钮 */
    submitForm: function () {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            console.log()
          } else {
            console.log()
          }
        }
      });
    },
  }
};
</script>

<style scoped>

</style>
