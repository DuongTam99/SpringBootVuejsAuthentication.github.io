<template>
  <div class=" bg-repeat-round bg-containt bg-center">
    <div id="parentx">
      <vs-row vs-justify="center">
        <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="4">
          <vs-card actionable class="cardx">
            <div slot="header">
              <h2>USER</h2>
              <h3>
                Hello Meo {{currentUser.username}}
              </h3>
            </div>
            <div slot="media">
              <img :src="'http://icdn.dantri.com.vn/zoom/1200_630/2021/09/08/meo-crop-1631079099680.jpeg'">
            </div>
            <div>
              <span>ID: {{currentUser.Id}}</span>
            </div>
            <div>
              <span>{{currentUser.roles}}</span>
            </div>
            <div slot="footer">
              <vs-row vs-justify="flex-end">
                <vs-button @click="active=!active" color="warning" type="filled">Mở thông tin nhiệm vụ </vs-button>
              </vs-row>
            </div>
          </vs-card>
        </vs-col>
      </vs-row>
      <vs-sidebar parent="body" default-index="1" color="warning" class="sidebarx" spacer v-model="active">
        <div class="header-sidebar" slot="header">
          <vs-avatar size="70px"
            src="https://img.freepik.com/vecteurs-premium/illustration-icone-vecteur-dessin-anime-ninja-chat-mignon-concept-icone-nature-animale-isole-vecteur-premium-style-dessin-anime-plat_138676-4232.jpg" />
          <h4>
            {{currentUser.username}}
            <vs-button color="primary" icon="more_horiz" type="flat"></vs-button>
          </h4>
        </div>
        <vs-sidebar-group title="Vai trò">
          <vs-sidebar-item index="1" icon="question_answer">
            {{currentUser.roles}}
          </vs-sidebar-item>
          <vs-sidebar-group title="Công việc hôm nay">
            <vs-sidebar-item index="2.1" icon="store">
              Quét sân
            </vs-sidebar-item>
            <vs-sidebar-item index="2.2" icon="nature_people">
              Giặt đồ
            </vs-sidebar-item>
            <vs-sidebar-item index="2.3" icon="style">
              Rửa chén
            </vs-sidebar-item>
          </vs-sidebar-group>
          <vs-sidebar-item index="2" icon="gavel">
            Lịch sử
          </vs-sidebar-item>
          <vs-sidebar-item index="3" icon="https">
            Bảo mật
          </vs-sidebar-item>
          <vs-sidebar-item index="4" icon="help">
            Trợ giúp
          </vs-sidebar-item>
        </vs-sidebar-group>
        <vs-divider icon="person" position="left">
          User
        </vs-divider>
        <vs-sidebar-item index="5" icon="verified_user">
          Nhân viên sale
        </vs-sidebar-item>
        <vs-sidebar-item index="6" icon="account_box">
          Profile
        </vs-sidebar-item>
        <div class="footer-sidebar" slot="footer">
          <vs-button color="danger" type="flat">log out</vs-button>
        </div>
      </vs-sidebar>
    </div>
  </div>
</template>
<script>
// import UserService from '../services/user.service';
export default {
  name: 'TestingUser',
  data() {
    return {
      content: '', active: false
    };
  },
  //Khi can thong bao loi 
  // mounted() {
  //   UserService.getUserBoard().then(
  //     response => {
  //       this.content = response.data;
  //     },
  //     error => {
  //       this.content =
  //         (error.response && error.response.data) ||
  //         error.message ||
  //         error.toString();
  //     }
  //   );
  // },
  
  
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  }
};
</script>