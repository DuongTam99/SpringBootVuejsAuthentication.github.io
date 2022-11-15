<template>

  <div>
    <vs-row vs-justify="center" >
      <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="4"  >
        <vs-card actionable class="cardx">
          <div slot="header">
            <h3>
              Hello Meo {{ currentUser.username }}
            </h3>
          </div>
          <div slot="media">
            <img :src="'http://icdn.dantri.com.vn/zoom/1200_630/2021/09/08/meo-crop-1631079099680.jpeg'">
          </div>
          <div>
            <span  >ID: {{ currentUser.Id }}</span>

          </div>

          <div>
            <span>ROLE: {{ currentUser.roles }}</span>

          </div>
        </vs-card>
      </vs-col>
      <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="4">
       
       
        <vs-card actionable class="cardx">
        <div slot="header">Cân nặng theo thời gian năm nay</div>
<div>
  <apexchartToo width="500"  height="345" type="line" :options="options" :series="series"></apexchartToo>
</div>
</vs-card>
     
      </vs-col>
      <vs-col type="flex" vs-justify="center" vs-align="center" vs-w="10">
        <vs-card actionable class="cardx">
          <vs-input label-placeholder="Time" v-model="newTodoTime" />
          <vs-input label-placeholder="Them ghi chu hom nay" v-model="newTodo" />
          <br />
          <vs-button color="#dbc6a7" @click="addTodo">PUSH</vs-button>
          <div>
            <transition name="slide-fade">
              <vs-table :data="todos">
                <template slot="header">
                </template>
                <template slot="thead">
                  <vs-th>
                    Time
                  </vs-th>
                  <vs-th>
                    Work
                  </vs-th>
                  <vs-th>
                    Checked

                  </vs-th>
                  <vs-th>
                    Delete
                  </vs-th>
                </template>
                <template slot-scope="{data}">
                  <vs-tr :key="indextr" v-for="(tr, indextr) in data"
                    :class="data[indextr].done ? 'showred' : 'noshowred'">
                    <vs-td :data="data[indextr].time">
                      {{ data[indextr].time }}
                    </vs-td>
                    <vs-td :data="data[indextr].message">
                      {{ data[indextr].message }}
                    </vs-td>
                    <vs-td :data="data[indextr].done">
                      <vs-checkbox color="#dbc6a7" v-model="data[indextr].done" />
                      <vs-progress v-if="!data[indextr].done" indeterminate color="warning">primary</vs-progress>
                    </vs-td>
                    <vs-td :data="data[indextr].done">
                      <vs-button color="#A52A2A" @click="removeTodo(data[indextr])">Delete</vs-button>
                    </vs-td>
                  </vs-tr>
                </template>
              </vs-table>
            </transition>
          </div>
        </vs-card>
      </vs-col>
    </vs-row>
  </div>
</template>
<script>

export default {
  
  data() {
    return {


      options: {
        chart: {
          id: 'vuechart-example'
        },
        xaxis: {
          categories: ["1/2022","2/2022","3/2022","4/2022","5/2022","6/2022","7/2022","8/2022","9/2022","10/2022","11/2022","12/2022"]
        }
      },
      series: [{
        name: 'kg',
        data: [3, 4, 4, 5, 4, 6, 7, 9,9,8,10,14]
      }],



      show: true,
      newTodo: '',
      newTodoTime: '',

      todos: [
        { message: "Di hop", done: true, time: "14h30" },
        { message: " Ki hop", done: false, time: "16h30" },
        { message: " Di ve", done: true, time: "17h30" },
        { message: " Di hen ho", done: true, time: "18h30" }
      ]
    }
  },
  name: 'TestingProfile',

  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  methods: {
    checkDone() {
      return this.books.filter(work => work.done)
    },
    addTodo() {
      this.todos.push({ message: this.newTodo, done: false, time: this.newTodoTime })
      this.newTodo = ''
      this.newTodoTime = ''
    },
    removeTodo(todo) {
      this.todos = this.todos.filter((t) => t !== todo)

    }
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
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
</style>