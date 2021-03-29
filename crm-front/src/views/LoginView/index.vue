<template>
  <div class="page">
    <img id="img" src="@/assets/mountain.jpg"/>
    <div class="loginwarrp">
      <div class="logo">Login</div>
      <div class="login_form">
        <el-form id="Login" ref="formInline" name="Login" method="post" onsubmit="" action="" :model="formInline"
              :rules="ruleInline">
          <el-form-item prop="username" class="form-item">
            <li class="login-item">
              <span>&nbsp;&nbsp;&nbsp;用户名：&nbsp;&nbsp;</span>
              <el-input type="text" id="username" name="username" class="login_input" v-model="formInline.username">
              </el-input>
              <span id="count-msg" class="error"></span>
            </li>
          </el-form-item>
          <el-form-item prop="password" class="form-item">
            <li class="login-item">
              <span>&nbsp;&nbsp;&nbsp;&nbsp;密　码：&nbsp;&nbsp;</span>
              <el-input type="password" id="password" name="password" class="login_input" v-model="formInline.password">
              </el-input>
              <span id="password-msg" class="error"></span>
            </li>
          </el-form-item>
          <el-form-item prop="verifyCode" class="form-item">
            <li class="login-item verify">
              <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;验证码：&nbsp;&nbsp;</span>
              <el-input type="text" name="verifyCode" id="verifyCod e" class="login_input verify_input"
                     v-model="formInline.verifyCode">
              </el-input>
              <span id="CheckCode-msg" class="error"></span>
            </li>
            <div id="code">
              <img :src="vcUrl" border="1" class="verifyimg" @click="updateVerifyCode" style="cursor:pointer" alt=""/>
            </div>
          </el-form-item>
          <div class="clearfix"></div>
          <li class="login-sub">
            <input type="button" name="Submit" @click="handleSubmit('formInline')" value="登录"/>
            <input type="reset" name="Reset" value="重置"/>
          </li>
        </el-form>
      </div>
    </div>
  </div>
</template>
<script>
import {getLogin} from '@/api/login'

export default {
  name: "LoginView",
  data() {
    return {
      formInline: {
        username: 'admin',
        password: '123456',
        verifyCode: ''
      },
      ruleInline: {
        username: [
          {required: true, message: '请填写用户名', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请填写密码', trigger: 'blur'},
          {type: 'string', min: 6, message: '密码长度不能小于6位', trigger: 'blur'}
        ],
        verifyCode: [
          {required: true, message: '请输入验证码', trigger: 'blur'}
        ]
      },
      vcUrl: process.env.VUE_APP_BASE_API + '/verifyCode?time' + new Date()
    }
  },
  methods: {
    handleSubmit(name) {
      this.$refs[name].validate((valid) => {
        if (valid) {
          getLogin('/doLogin', this.formInline).then(res => {
            console.log(res);
            if (res.code === 200) {
              localStorage.setItem('user', JSON.stringify(res.data))
              localStorage.setItem('authorization', res.headers.authorization)
              this.$router.push('/DoubleView')
            } else {
              this.vcUrl = process.env.VUE_APP_BASE_API + '/verifyCode?time=' + new Date();
            }
          })
        } else {
          alert("账号或者密码错误")
          this.$Message.error('表单验证失败!')
        }
      })
    },
    updateVerifyCode() {
      this.vcUrl = process.env.VUE_APP_BASE_API + '/verifyCode?time' + new Date()
    }
  }
}
</script>
<style>
.page {
  margin: -150px auto;
}

body {
  text-align: center;
  margin: 0;
}

#img {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  right: 100px;
  bottom: 500px;
  z-index: -1;
}

.loginwarrp {
  margin: 250px auto;
  width: 400px;
  padding: 30px 50px;
  background: #888d97;
  border: 0px;
  opacity: 0.8;
  border-radius: 15px;
  overflow: hidden;
  font-size: 14px;
  font-family: '微软雅黑', '文泉驿正黑', '黑体';
}

.loginwarrp .logo {
  width: 100%;
  height: 44px;
  line-height: 44px;
  font-size: 20px;
  text-align: center;
  border-bottom: 1px solid #ddd;
}

.loginwarrp .login_form {
  margin-top: 15px;
}

.loginwarrp .login_form .login-item {
  padding: 2px 8px;
  border: 1px solid #dedede;
  border-radius: 8px;
  margin-top: 10px;
}

.loginwarrp .login_form .login_input {
  height: 35px;
  border: none;
  line-height: 35px;
  width: 200px;
  font-size: 14px;
  outline: none;
}

.loginwarrp .login_form .verify {
  float: left;
}

.loginwarrp .verify .verify_input {
  width: 100px;
}

.loginwarrp .verifyimg {
  height: 30px;
  margin: 20px 0 0 20px;
}

.loginwarrp .login-sub {
  text-align: center;
}

.loginwarrp .login-sub input {
  margin-top: 15px;
  background: #45B549;
  line-height: 35px;
  width: 150px;
  color: #FFFFFF;
  font-size: 16px;
  font-family: '微软雅黑', '文泉驿正黑', '黑体';
  border: none;
  border-radius: 5px;
}

.loginwarrp .login_form .login-item .error {
  color: #F00;
  font-family: '微软雅黑', '文泉驿正黑', '黑体';
}

article, aside, details, figcaption, figure,
footer, header, hgroup, menu, nav, section {
  display: block;
}

body {
  line-height: 1;
}

ol, ul, li {
  list-style: none;
}

blockquote, q {
  quotes: none;
}

blockquote:before, blockquote:after,
q:before, q:after {
  content: '';
  content: none;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
}

a {
  text-decoration: none;
  color: #333;
  display: block;
}

body {
  font-size: 14px;
}

#code {
  display: flex;
}
</style>
