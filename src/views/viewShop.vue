<template>
  <div>
    <vs-row vs-justify="center">
      <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="3">
        <vs-card actionable class="cardx">
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

          </div>
          <div slot="header">
            <vs-input class="" icon-after="true" label-placeholder="icon-after" icon="account_circle"
              placeholder="Tên" />
            <vs-input icon-after="true" label-placeholder="icon-after" icon="mode_edit" placeholder="Nhập địa chỉ" />
            <vs-input icon-after="true" label-placeholder="icon-after" icon="email" placeholder="Email" />
            <br />
            <h2>{{formatt(cart.price)}}</h2>
            <vs-input-number v-model="number0" :step="1" class="" />
          </div>
          <vs-row vs-justify="flex-end">
            <vs-button v-if="!showPay" color="primary" type="gradient" @click="pay()">PAY</vs-button>
          </vs-row>
          <vs-alert v-if="showPay" title="Success" active="true" color="success">
          </vs-alert>
        </vs-card>
      </vs-col>
    </vs-row>
  </div>
</template>
<script>
const formatter = new Intl.NumberFormat('vi-VN', {
  style: 'currency',
  currency: 'VND',
  minimumFractionDigits: 2
})
export default {
  props: {
    cart: {
}
},
  data() {
    return {
      showPay: false,
      number0: 1
}
  },
  name: 'TestingProfile',
  methods: {
    formatt(a) {
      return formatter.format(a * this.number0)
    },
    pay() {
      this.showPay = !this.showPay
    }
}
};
</script>
<style scoped>
.showred {
  color: #dbc6a7;
}
.noshowred {
  color: #A52A2A;
  ;
}
.slide-fade-enter-active {
  transition: all 5s ease-out;
}

.slide-fade-leave-active {
  transition: all 5s cubic-bezier(1, 0.5, 0.8, 1);
}

.slide-fade-enter-from,
.slide-fade-leave-to {
  transform: translateX(20px);
  opacity: 0;
}
.vs-con-input-label {

  width: 400px;
}
.vs-input-number {

  justify-content: start;
  background: none;
}
</style>