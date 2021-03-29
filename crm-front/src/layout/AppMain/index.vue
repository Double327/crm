<template>
  <section class="app-main">
    <transition name="fade-transform" mode="out-in">
      <keep-alive>
        <router-view :key="key"/>
      </keep-alive>
    </transition>
    <!--<div v-if="$store.state.settings.showFooter" id="el-main-footer">-->
    <!--  <span v-html="$store.state.settings.footerTxt"/>-->
    <!--  <span> ⋅ </span>-->
    <!--  <a href="http://www.beian.miit.gov.cn" target="_blank">{{ $store.state.settings.caseNumber }}</a>-->
    <!--</div>-->
  </section>
</template>

<script>
export default {
  name: "AppMain"
}
</script>

<style scoped lang="scss">
.app-main {
  width: 100%;
  padding: 20px;
  min-height: calc(100vh - 50px);
  float: left;
  position: relative;
  overflow: hidden;
}

.fixed-header + .app-main {
  padding-top: 50px;
}

.hasTagsView {
  .app-main {
    /* 84 = navbar + tags-view = 50 + 34 */
    min-height: calc(100vh - 84px);
  }

  .fixed-header + .app-main {
    padding-top: 84px;
  }
}
</style>

<style lang="scss">
// fix css style bug in open el-dialog
.el-popup-parent--hidden {
  .fixed-header {
    padding-right: 15px;
  }
}
</style>
