<template>
  <div class="">
    <div>
      <section
        class="h-full gradient-form bg-gray-200 md:h-screen  bg-[url('https://img.freepik.com/free-vector/minimal-cat-background-line-art-illustration-vector_53876-151371.jpg?w=2000')]">
        <div class="container py-12 px-6 h-full">
          <div class="
            flex
            justify-center
            items-center
            flex-wrap
            h-full
            g-6
            text-gray-800
          ">
            <div class="xl:w-10/12">
              <div class="block bg-white shadow-lg rounded-lg">
                <div class="lg:flex lg:flex-wrap g-0">
                  <div class="lg:w-6/12 px-4 md:px-0">
                    <div class="md:p-12 md:mx-6">
                      <div class="text-center">
                        <img class="mx-auto w-48"
                          src="data:image/png;base64,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"
                          alt="logo" />
                        <h4 class="text-xl font-semibold mt-1 mb-12 pb-1">
                          We are MEO Team
                        </h4>
                      </div>

                      <form name="form" @submit.prevent="handleLogin">
                        <p class="mb-4">Please login to your account</p>
                        <div class="mb-4">
                          <vs-input color="success" type="text" name="username" label-placeholder="Username"
                            v-model="user.username" v-validate="'required'" class="
                            w-full" />
                          <div v-if="errors.has('username')" class="
                            bg-red-100
                            rounded-lg
                            py-5
                            px-6
                            mb-4
                            text-base text-red-700
                            mb-3
                          ">
                            Username is required!
                          </div>
                        </div>
                        <vs-input v-model="user.password" color="success" v-validate="'required'" type="password" class="
                          w-full" name="password" placeholder="Password" />
                        <div v-if="errors.has('password')" class="
                            bg-red-100
                            rounded-lg
                            py-5
                            px-6
                            mb-4
                            text-base text-red-700
                            mb-3
                          ">
                          Password is required!
                        </div>
                        <div class="text-center pt-1 mb-12 pb-1">
                          <button @click="openLoading" class="
                            inline-block
                            px-6
                            py-2.5
                            text-green
                            font-medium
                            text-xs
                            leading-tight
                            uppercase
                            rounded
                            shadow-md
                            hover:bg-blue-700 hover:shadow-lg
                            focus:shadow-lg focus:outline-none focus:ring-0
                            active:shadow-lg
                            transition
                            duration-150
                            ease-in-out
                            w-full
                            mb-3
                          ">
                            <div>
                              <span>Login</span>
                            </div>
                          </button>
                          <a class="text-gray-500" href="#!">Mèo bị quên mật khẩu?</a>
                        </div>
                        <div class="flex items-center justify-between pb-6">
                          <p class="mb-0 mr-2">Chưa gia nhập thị hãy đăng kí ngay nhé!</p>
                          <router-link to="/register"
                            class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">
                            Sign Up
                          </router-link>
                        </div>
                      </form>

                    </div>
                  </div>
                  <div class="
                    lg:w-6/12
                    flex
                    items-center
                    lg:rounded-r-lg
                    rounded-b-lg
                    lg:rounded-bl-none bg-repeat-round bg-containt bg-center bg-[url('https://i.pinimg.com/originals/a2/fb/96/a2fb96723266920b5e61987b745a3cdd.jpg')]
                  " style="
                    background: linear-gradient(
                      to right,
                      #ee7724,
                      #d8363a,
                      #dd3675,
                      #b44593
                    );
                  ">

                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>

  </div>
</template>
  <script>
import User from "../models/user";
export default {
  name: "TestingLogin",
  data() {
    return {
      show: true,
      user: new User("", ""),

      message: ""
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/profile");
    }
  },
  methods: {
    openLoading() {
      this.$vs.loading({ type: 'radius' })
      setTimeout(() => {
        this.$vs.loading.close()
      }, 2000);

    },
    handleLogin() {

      this.$validator.validateAll().then((isValid) => {
        if (!isValid) {
          this.$vs.notify({ title: 'Warning', text: 'Error validate, cannot login', color: 'warning' })

          return;
        } else if (this.user.username && this.user.password) {


          this.$store.dispatch("auth/login", this.user).then(
            () => {
              this.$vs.notify({ title: 'Success', text: 'Success for login', color: 'success' })
              this.$router.push({ name: "TestingProfile"});
            },
            (error) => {
              
                this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
                this.$vs.notify({ title: 'Danger', text: "Cannot login "+this.message, color: 'danger' })

            }
          );

        } else {
          this.$vs.notify({ title: 'w', text: 'Cannot Login with wrong username,password', color: 'warning' })
        }
      });
    },
  },

}





</script>
  <style scoped>
  .slide-fade-enter-active {
    transition: all 0.3s ease-out;
  }
  
  .slide-fade-leave-active {
    transition: all 0.8s cubic-bezier(1, 0.5, 0.8, 1);
  }
  
  .slide-fade-enter-from,
  .slide-fade-leave-to {
    transform: translateX(20px);
    opacity: 0;
  }
  </style>