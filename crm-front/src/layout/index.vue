<template>
  <div class="app-wrapper">
    <NavBar/>
    <div class="main-container">
      <el-row>
        <el-col :span='3'>
          <SideBar/>
        </el-col>
        <el-col :span='21'>
          <app-main/>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar";
import SideBar from "@/components/SideBar";
import AppMain from "@/layout/AppMain";

export default {
  name: "index",
  components: {SideBar, NavBar, AppMain}
}
</script>

<style scoped lang="scss">
@import "~@/assets/style/mixin.scss";
@import "~@/assets/style/variables.scss";
@import "~@/assets/style/index.scss";

.app-wrapper {
  @include clearfix;
  position: relative;
  height: 100%;
  width: 100%;

  &.mobile.openSidebar {
    position: fixed;
    top: 0;
  }
}

.drawer-bg {
  background: #000;
  opacity: 0.3;
  width: 100%;
  top: 0;
  height: 100%;
  position: absolute;
  z-index: 999;
}

.fixed-header {
  position: fixed;
  top: 0;
  right: 0;
  z-index: 9;
  width: calc(100% - #{$sideBarWidth});
  transition: width 0.28s;
}

.hideSidebar .fixed-header {
  width: calc(100% - 54px)
}

.mobile .fixed-header {
  width: 100%;
}
</style>
