<template>
  <div id="app">
    <div class="centerx">
    </div>
    <header class="relative z-50 w-full h-24">
      <div class="container flex items-center justify-center h-full max-w-6xl px-8 mx-auto sm:justify-between xl:px-0">
        <a href="/" class="relative flex items-center inline-block h-5 h-full font-black leading-none">
          <img width="80" height="100"
            src="data:image/png;base64,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" />
          <svg class="w-auto h-6 text-indigo-600 fill-current" viewBox="0 0 194 116" xmlns="http://www.w3.org/2000/svg">
            <g fill-rule="evenodd">
            </g>
          </svg>
          <span class="ml-3 text-xl text-gray-800">Meo<span class="text-pink-500">.</span></span>
        </a>
        <nav id="nav"
          class="absolute top-0 left-0 z-50 flex flex-col items-center justify-between hidden w-full h-64 pt-5 mt-24 text-sm text-gray-800 bg-white border-t border-gray-200 md:w-auto md:flex-row md:h-24 lg:text-base md:bg-transparent md:mt-0 md:border-none md:py-0 md:flex md:relative">
          <a href="#"
            class="ml-0 mr-0 font-bold duration-100 md:ml-12 md:mr-3 lg:mr-8 transition-color hover:text-indigo-600">
            <router-link to="/home">
              <vs-button type="line" color="dark">Home</vs-button>
            </router-link>
          </a>
          <a href="#" v-if="currentUser"
            class="ml-0 mr-0 font-bold duration-100 md:ml-12 md:mr-3 lg:mr-8 transition-color hover:text-indigo-600">
            <router-link to="/shopping">
              <vs-button type="line" color="dark">Shopping</vs-button>
            </router-link>
          </a>
          <a href="#" class="mr-0 font-bold duration-100 md:mr-3 lg:mr-8 transition-color hover:text-indigo-600">
            <router-link v-if="currentUser" to="/profile">
              <vs-button type="line" color="dark"> {{ currentUser.username }}</vs-button>
            </router-link>
          </a>
          <a href="#" class="mr-0 font-bold duration-100 md:mr-3 lg:mr-8 transition-color hover:text-indigo-600">
            <router-link v-if="currentUser" to="/user">
              <vs-button type="line" color="dark">User</vs-button>
            </router-link>
          </a>
          <a href="#" class="mr-0 font-bold duration-100 md:mr-3 lg:mr-8 transition-color hover:text-indigo-600">
            <router-link v-if="showAdminBoard" to="/admin">
              <vs-button type="line" color="dark">Admin</vs-button>
            </router-link>
          </a>
          <a href="#" class="mr-0 font-bold duration-100 md:mr-3 lg:mr-8 transition-color hover:text-indigo-600">
            <router-link v-if="showModeratorBoard" to="/mod">
              <vs-button type="line" color="dark">Mod</vs-button>
            </router-link>
          </a>
          <a href="#" class="mr-0 font-bold duration-100 md:mr-3 lg:mr-8 transition-color hover:text-indigo-600"><a
              v-if="currentUser" href @click.prevent="logOut">
              <vs-button type="line" color="dark">Logout</vs-button>
            </a></a>
        </nav>
        <div
          class="left-0 flex-col items-center justify-center  w-full pb-8 mt-48 border-b border-gray-200 md:relative md:w-auto md:bg-transparent md:border-none md:mt-0 md:flex-row md:p-0 md:items-end md:flex md:justify-between">
          <a href="#_"
            class="z-40 px-3 py-2 text-sm font-bold">
            <vs-button line-position="top" line-origin="left" color="warning" type="line" ><router-link v-if="!currentUser" to="/login">
              Login
            </router-link></vs-button>
          </a>
        
          <a href="#_" v-if="!currentUser"
            class="z-40 px-3 py-2 text-sm font-bold   ">
            <vs-button line-position="top" line-origin="left" color="warning" type="line"><router-link to="/register">
              Sign Up
            </router-link></vs-button>
            
          </a>
          <svg class="absolute top-0 left-0 hidden w-screen max-w-3xl -mt-64 -ml-12 lg:block" viewBox="0 0 818 815"
            xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
            <defs>
              <linearGradient x1="0%" y1="0%" x2="100%" y2="100%" id="c">
                <stop stop-color="#FAEBD7" offset="0%" />
                <stop stop-color="#A52A2A" offset="100%" />
              </linearGradient>
              <linearGradient x1="0%" y1="0%" x2="100%" y2="100%" id="f">
                <stop stop-color="#FAEBD7" offset="0%" />
                <stop stop-color="#FFEBCD" offset="100%" />
              </linearGradient>
              <filter x="-4.7%" y="-3.3%" width="109.3%" height="109.3%" filterUnits="objectBoundingBox" id="a">
                <feOffset dy="8" in="SourceAlpha" result="shadowOffsetOuter1" />
                <feGaussianBlur stdDeviation="8" in="shadowOffsetOuter1" result="shadowBlurOuter1" />
                <feColorMatrix values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.15 0" in="shadowBlurOuter1" />
              </filter>
              <filter x="-4.7%" y="-3.3%" width="109.3%" height="109.3%" filterUnits="objectBoundingBox" id="d">
                <feOffset dy="8" in="SourceAlpha" result="shadowOffsetOuter1" />
                <feGaussianBlur stdDeviation="8" in="shadowOffsetOuter1" result="shadowBlurOuter1" />
                <feColorMatrix values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.2 0" in="shadowBlurOuter1" />
              </filter>
              <path
                d="M160.52 108.243h497.445c17.83 0 24.296 1.856 30.814 5.342 6.519 3.486 11.635 8.602 15.12 15.12 3.487 6.52 5.344 12.985 5.344 30.815v497.445c0 17.83-1.857 24.296-5.343 30.814-3.486 6.519-8.602 11.635-15.12 15.12-6.52 3.487-12.985 5.344-30.815 5.344H160.52c-17.83 0-24.296-1.857-30.814-5.343-6.519-3.486-11.635-8.602-15.12-15.12-3.487-6.52-5.343-12.985-5.343-30.815V159.52c0-17.83 1.856-24.296 5.342-30.814 3.486-6.519 8.602-11.635 15.12-15.12 6.52-3.487 12.985-5.343 30.815-5.343z"
                id="b" />
              <path
                d="M159.107 107.829H656.55c17.83 0 24.296 1.856 30.815 5.342 6.518 3.487 11.634 8.602 15.12 15.12 3.486 6.52 5.343 12.985 5.343 30.816V656.55c0 17.83-1.857 24.296-5.343 30.815-3.486 6.518-8.602 11.634-15.12 15.12-6.519 3.486-12.985 5.343-30.815 5.343H159.107c-17.83 0-24.297-1.857-30.815-5.343-6.519-3.486-11.634-8.602-15.12-15.12-3.487-6.519-5.343-12.985-5.343-30.815V159.107c0-17.83 1.856-24.297 5.342-30.815 3.487-6.519 8.602-11.634 15.12-15.12 6.52-3.487 12.985-5.343 30.816-5.343z"
                id="e" />
            </defs>
            <g fill="none" fill-rule="evenodd" opacity=".9">
              <g transform="rotate(65 416.452 409.167)">
                <use fill="#000" filter="url(#)" xlink:href="" />
                <use fill="url(#c)" xlink:href="#b" />
              </g>
              <g transform="rotate(29 421.929 414.496)">
                <use fill="#000" filter="url(#d)" xlink:href="#e" />
                <use fill="url(#f)" xlink:href="#e" />
              </g>
            </g>
          </svg>
        </div>
        <div id="nav-mobile-btn"
          class="absolute top-0 right-0 z-50 block w-6 mt-8 mr-10 cursor-pointer select-none md:hidden sm:mt-10">
          <span class="block w-full h-1 mt-2 duration-200 transform bg-gray-800 rounded-full sm:mt-1"></span>
          <span class="block w-full h-1 mt-1 duration-200 transform bg-gray-800 rounded-full"></span>
        </div>
      </div>
    </header>
    <div>
      <transition name="slide-fade" :duration="{ enter: 500, leave: 800 }">
        <router-view />
      </transition>
    </div>
    <footer class="px-4 pt-12 pb-8 text-white bg-white border-t border-gray-200">
      <div class="container flex flex-col justify-between max-w-6xl px-4 mx-auto overflow-hidden lg:flex-row">
        <div class="w-full pl-12 mr-4 text-left lg:w-1/4 sm:text-center sm:pl-0 lg:text-left">
          <a href="/"
            class="flex justify-start block text-left sm:text-center lg:text-left sm:justify-center lg:justify-start">
          </a>
          <p class="mt-6 mr-4 text-base text-gray-500">Tập đoàn MEO sẽ vương xa và thống trị
          </p>
        </div>
        <div class="block w-full pl-10 mt-6 text-sm lg:w-3/4 sm:flex lg:mt-0">
          <ul class="flex flex-col w-full p-0 font-medium text-left text-gray-700 list-none">
            <li class="inline-block px-3 py-2 mt-5 font-bold tracking-wide text-gray-800 uppercase md:mt-0">
              Câu lạc bộ mèo</li>
            <li><a href="#_" class="inline-block px-3 py-2 text-gray-500 no-underline hover:text-gray-600">Mèo Nhảy</a>
            </li>
            <li><a href="#_" class="inline-block px-3 py-2 text-gray-500 no-underline hover:text-gray-600">Mèo Đọc
                sách</a>
            </li>
            <li><a href="#_" class="inline-block px-3 py-2 text-gray-500 no-underline hover:text-gray-600">Mèo game</a>
            </li>
            <li><a href="#_" class="inline-block px-3 py-2 text-gray-500 no-underline hover:text-gray-600">Mèo hẹn
                hò</a></li>
          </ul>
          <ul class="flex flex-col w-full p-0 font-medium text-left text-gray-700 list-none">
            <li class="inline-block px-3 py-2 mt-5 font-bold tracking-wide text-gray-800 uppercase md:mt-0">
              Tập đoàn MEO</li>
            <li><a href="#_" class="inline-block px-3 py-2 text-gray-500 no-underline hover:text-gray-600">HCM</a>
            </li>
            <li><a href="#_" class="inline-block px-3 py-2 text-gray-500 no-underline hover:text-gray-600">HN</a></li>
          </ul>
          <ul class="flex flex-col w-full p-0 font-medium text-left text-gray-700 list-none">
            <li class="inline-block px-3 py-2 mt-5 font-bold tracking-wide text-gray-800 uppercase md:mt-0">
              Thông điệp
            </li>
            <li><a href="https://devdojo.com/tailwindcss/components"
                class="inline-block px-3 py-2 text-gray-500 no-underline hover:text-gray-600">Chiếm trái đất</a></li>
            <li><a href="https://devdojo.com/tailwindcss/templates"
                class="inline-block px-3 py-2 text-gray-500 no-underline hover:text-gray-600">Thống trị thế giới</a>
            </li>
          </ul>
          <div class="flex flex-col w-full text-gray-700">
            <div class="inline-block px-3 py-2 mt-5 font-bold text-gray-800 uppercase md:mt-0">Follow Us</div>
            <div class="flex justify-start pl-4 mt-2">
              <a class="flex items-center block mr-6 text-gray-400 no-underline hover:text-gray-600" target="_blank"
                rel="noopener noreferrer" href="https://devdojo.com">
                <svg viewBox="0 0 24 24" class="w-5 h-5 fill-current" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M23.998 12c0-6.628-5.372-12-11.999-12C5.372 0 0 5.372 0 12c0 5.988 4.388 10.952 10.124 11.852v-8.384H7.078v-3.469h3.046V9.356c0-3.008 1.792-4.669 4.532-4.669 1.313 0 2.686.234 2.686.234v2.953H15.83c-1.49 0-1.955.925-1.955 1.874V12h3.328l-.532 3.469h-2.796v8.384c5.736-.9 10.124-5.864 10.124-11.853z" />
                </svg>
              </a>
              <a class="flex items-center block mr-6 text-gray-400 no-underline hover:text-gray-600" target="_blank"
                rel="noopener noreferrer" href="https://devdojo.com">
                <svg viewBox="0 0 24 24" class="w-5 h-5 fill-current" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M23.954 4.569a10 10 0 01-2.825.775 4.958 4.958 0 002.163-2.723c-.951.555-2.005.959-3.127 1.184a4.92 4.92 0 00-8.384 4.482C7.691 8.094 4.066 6.13 1.64 3.161a4.822 4.822 0 00-.666 2.475c0 1.71.87 3.213 2.188 4.096a4.904 4.904 0 01-2.228-.616v.061a4.923 4.923 0 003.946 4.827 4.996 4.996 0 01-2.212.085 4.937 4.937 0 004.604 3.417 9.868 9.868 0 01-6.102 2.105c-.39 0-.779-.023-1.17-.067a13.995 13.995 0 007.557 2.209c9.054 0 13.999-7.496 13.999-13.986 0-.209 0-.42-.015-.63a9.936 9.936 0 002.46-2.548l-.047-.02z" />
                </svg>
              </a>
              <a class="flex items-center block text-gray-400 no-underline hover:text-gray-600" target="_blank"
                rel="noopener noreferrer" href="https://devdojo.com">
                <svg viewBox="0 0 24 24" class="w-5 h-5 fill-current" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M12 .297c-6.63 0-12 5.373-12 12 0 5.303 3.438 9.8 8.205 11.385.6.113.82-.258.82-.577 0-.285-.01-1.04-.015-2.04-3.338.724-4.042-1.61-4.042-1.61C4.422 18.07 3.633 17.7 3.633 17.7c-1.087-.744.084-.729.084-.729 1.205.084 1.838 1.236 1.838 1.236 1.07 1.835 2.809 1.305 3.495.998.108-.776.417-1.305.76-1.605-2.665-.3-5.466-1.332-5.466-5.93 0-1.31.465-2.38 1.235-3.22-.135-.303-.54-1.523.105-3.176 0 0 1.005-.322 3.3 1.23.96-.267 1.98-.399 3-.405 1.02.006 2.04.138 3 .405 2.28-1.552 3.285-1.23 3.285-1.23.645 1.653.24 2.873.12 3.176.765.84 1.23 1.91 1.23 3.22 0 4.61-2.805 5.625-5.475 5.92.42.36.81 1.096.81 2.22 0 1.606-.015 2.896-.015 3.286 0 .315.21.69.825.57C20.565 22.092 24 17.592 24 12.297c0-6.627-5.373-12-12-12" />
                </svg>
              </a>
            </div>
          </div>
        </div>
      </div>
      <div class="pt-4 pt-6 mt-10 text-center text-gray-500 border-t border-gray-100">© 2022 . Project.</div>
      <div class="pt-2 pt-4 mt-2 text-center text-gray-600 border-t border-gray-100">By Tam</div>
    </footer>
  </div>
</template>
<script>
export default {
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_ADMIN');
      }
      return false;
    },
    showModeratorBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_MODERATOR');
      }
      return false;
    }
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  }, data: () => ({
  })
};
</script>
<style>
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