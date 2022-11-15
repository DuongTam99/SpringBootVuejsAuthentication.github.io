<template>
  <div>
    <vs-row vs-justify="center">
      <vs-col v-for="(cart,key) in carts" :key="key" type="flex" vs-justify="center" vs-align="center" vs-w="3">
        <vs-card actionable class="cardx" v-if="show">
          <div slot="header">
            <h3>
              {{cart.title}}
            </h3>
          </div>
          <div slot="media">
            <img class="object-fill h-70 w-48" :src=cart.src>
          </div>
          <div>
            <span>{{cart.content}}</span>
            <h2>{{formatt(cart.price)}}</h2>
          </div>
          <div slot="footer">
            <vs-row vs-justify="flex-end">
              <vs-button color="primary" type="gradient" @click="select(cart)">View</vs-button>

            </vs-row>
          </div>
        </vs-card>
      </vs-col>
    </vs-row>
    <view-shop v-if="!show" :cart="selectCart"></view-shop>
  </div>
</template>
<script>
import viewShop from './viewShop.vue';
const formatter = new Intl.NumberFormat('vi-VN', {
  style: 'currency',
  currency: 'VND',
  minimumFractionDigits: 2
})
export default {
  components: { viewShop },
  data() {
    return {
      selectCart: '',
      carts: [
        { price: 1500000, title: "Áo mèo ninja", content: "Áo Meo ninja cho những con mèo lì lợm, áo chắc chắn, không bung lụa khi bị dộp", src: "https://img.bestdealplus.com/ae04/kf/H034d47264aab479b8b8044ef6cf887cea.jpg" },
        { price: 1000000, title: "Áo mèo Superme ", content: "Áo Meo Superme cho những con mèo ngầu lòi, áo chắc chắn, không bung lụa khi bị dộp", src: "https://petviet.vn/wp-content/uploads/2019/05/Quan-ao-cho-meo.jpg" }
      ],
      show: true,
    }
  },
  name: 'TestingProfile',
  computed: {
  },
  methods: {
    select(cart) {
      this.show = !this.show;
      this.selectCart = cart


    }, formatt(a) {
      return formatter.format(a)
    }
  },
  component: {
    viewShop
  }
};
</script>
<style scoped>
</style>