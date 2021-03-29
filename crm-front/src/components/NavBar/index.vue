<template>
  <div class="navbar">
    <div class="left-box">
      客户关系管理系统
    </div>
    <div class="right-menu">
      <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click">
        <div class="avatar-wrapper">
          <img src="@/assets/avatar/al_1.png" class="user-avatar">
          <i class="el-icon-caret-bottom"/>
        </div>
        <el-dropdown-menu slot="dropdown">
          <router-link to="/user/profile">
            <el-dropdown-item>个人中心</el-dropdown-item>
          </router-link>
          <el-dropdown-item>
            <span @click="setting = true">布局设置</span>
          </el-dropdown-item>
          <el-dropdown-item divided>
            <span @click="logout">退出登录</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "NavBar",
  methods: {
    logout() {

    }
  }
}
</script>

<style scoped lang="scss">
.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0, 21, 41, .08);


  .errLog-container {
    display: inline-block;
    vertical-align: top;
  }

  .left-box {
    float: left;
    height: 100%;
    line-height: 50px;

    .title {
      font-size: 20px;
      line-height: 30px;
    }
  }

  .right-menu {
    float: right;
    height: 100%;
    line-height: 50px;

    & :focus {
      outline: none;
    }

    .right-menu-item {
      display: inline-block;
      padding: 0 8px;
      height: 100%;
      font-size: 18px;
      color: #5a5e66;
      vertical-align: text-bottom;

      &
      .hover-effect {
        cursor: pointer;
        transition: background .3s;

        &
        :hover {
          background: rgba(0, 0, 0, .025)
        }

      }
    }

    .avatar-container {
      margin-right: 30px;

      .avatar-wrapper {
        margin-top: 5px;
        position: relative;

        .user-avatar {
          cursor: pointer;
          width: 40px;
          height: 40px;
          border-radius: 10px;
        }

        .el-icon-caret-bottom {
          cursor: pointer;
          position: absolute;
          right: -20px;
          top: 25px;
          font-size: 12px;
        }

      }
    }
  }
}
</style>
