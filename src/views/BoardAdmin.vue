<template>
  <div class=" bg-repeat-round bg-containt bg-center">

    <div id="parentx">
    <vs-row vs-justify="center">
        <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="4">
          <vs-card actionable class="cardx">
            <div slot="header">
              <h2>ADMIN</h2>
              <h3>
                Hello Meo {{currentUser.username}}
              </h3>
            </div>
            <div slot="media">
              <img :src="'https://img.bestdealplus.com/ae04/kf/H034d47264aab479b8b8044ef6cf887cea.jpg'">
            </div>
            <div>
              <span>ID: {{currentUser.Id}}</span>

            </div>
            <div>
              <span></span>

            </div>
            <div>
              <span> {{currentUser.roles}}</span>

            </div>
            <div slot="footer">
              <vs-row vs-justify="flex-end">

                <vs-button @click="active=!active" color="warning" type="filled">Mở thông tin nhiệm vụ Admin
                </vs-button>

              </vs-row>
            </div>
            <br/>
            <Strong>Thông tin tất cả User</Strong>
           
            <table id="datatable" class="border-separate border-spacing-2 border border-slate-800">
              <thead>
                <tr>
                  <th class="border border-slate-300 bg-yellow-500 hover:bg-yellow-400">ID</th>
                  <th class="border border-slate-300 bg-yellow-500 hover:bg-yellow-400">Name</th>

                </tr>

              </thead>
              <tbody>
                <tr class="hover:bg-orange-100" v-for="user in users" :key="user.id">
                  <td >{{ user.id }}</td>

                  <td > {{ user.username }}</td>


                </tr>
              </tbody>
            </table>

          </vs-card>
        </vs-col>
      </vs-row>
      <vs-sidebar parent="body" default-index="1" color="warning" class="sidebarx" spacer v-model="active">
        <div class="header-sidebar" slot="header">
          <vs-avatar size="70px" src="https://img.bestdealplus.com/ae04/kf/H034d47264aab479b8b8044ef6cf887cea.jpg" />
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
              Hop với tập đoàn hải cẩu
            </vs-sidebar-item>
            <vs-sidebar-item index="2.2" icon="nature_people">
              Kí kết đình chiến với tập đoàn chuột
            </vs-sidebar-item>
            <vs-sidebar-item index="2.3" icon="style">
              Kế hoạc gia tăng sản lượng ca
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
import "jquery/dist/jquery.min.js";
import "bootstrap/dist/css/bootstrap.min.css";
import "datatables.net-dt/js/dataTables.dataTables";
import "datatables.net-dt/css/jquery.dataTables.min.css";
import $ from "jquery";

export default {
  name: 'TestingAdmin',
  data() {
    return {
      active: false,
      users: []
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    fetch("http://localhost:8080/auth/dashboard")
      .then((response) => response.json())
      .then((data) => {
        this.users = data;
        setTimeout(() => {
          $("#datatable").DataTable({
            lengthMenu: [
              [5, 10, 25, 50, -1],
              [5, 10, 25, 50, "All"],
            ],
            pageLength: 10,
          });
        });
      });
  }
};

</script>
<style scoped>
.dataTables_wrapper .dataTables_paginate .paginate_button.current {
  background: linear-gradient(to bottom, rgba(230, 230, 230, 0.1) 0%, #FFEBCD 100%);
}
</style>