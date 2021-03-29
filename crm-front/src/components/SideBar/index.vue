<template>
  <div class="sidebar-container">
    <el-menu
        default-active="1"
        class="el-menu-vertical-demo"
        router
    >
      <el-submenu
          v-for="(resourceItem) in menuList"
          :key="resourceItem.id"
          :index="resourceItem.id.toString()"
      >
        <template slot="title">
          <i :class="'el-' + resourceItem.icon"></i>
          <span>{{ resourceItem.text }}</span>
        </template>
        <el-menu-item
            v-for="(child, cIndex) in resourceItem.children"
            :key="resourceItem.id + '-' + cIndex"
            :index="child.url"
        >
          {{ child.text }}
        </el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
import {getResource} from "@/api/resource";

export default {
  name: "SideBar",
  mounted() {
    getResource().then(res => {
      this.menuList = res.data;
    })
  },
  data() {
    return {
      menuList: undefined
    }
  }
}
</script>

<style scoped lang="scss">
</style>
