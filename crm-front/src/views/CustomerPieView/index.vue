<template>
  <!--为echarts准备一个具备大小的容器dom-->
  <div id="main" style="width: 1200px;height: 800px;"></div>
</template>
<script>
import * as echarts from 'echarts'
import {
  PieChart
} from 'echarts/charts';
import {
  CanvasRenderer
} from 'echarts/renderers';

echarts.use(
    [PieChart, CanvasRenderer]
);

export default {
  name: '',
  data() {
    return {
      dataList: [
        {"5": 2},
        {"4": 2},
        {"3": 1}
        // {value:235, name:'视频广告'},
        // {value:274, name:'联盟广告'},
        // {value:310, name:'邮件营销'},
        // {value:335, name:'直接访问'},
        // {value:400, name:'搜索引擎'}
      ]
    }
  },
  methods: {
    //json转换

    drawPie(id) {
      this.charts = echarts.init(document.getElementById(id))
      this.charts.setOption({
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: '80%',
            data: this.dataList,
            roseType: 'angle',
            label: {
              normal: {
                textStyle: {
                  color: 'rgba(0,0,0,0.3)'
                }
              }
            },
            labelLine: {
              normal: {
                lineStyle: {
                  color: 'rgb(0,0,0,0.3)'
                }
              }
            },
            itemStyle: {
              normal: {
                shadowBlur: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      })
    }
  },
  //调用
  mounted() {
    this.$nextTick(function () {
      this.drawPie('main')
    })
  }
}
</script>
<style scoped>
* {
  margin: auto;
  padding-top: 100px;
  list-style: none;
}
</style>
