
//    /**  @type {import('tailwindcss').Config} */
//module.exports = {
  //content: ["./src/**/*.{html,js}"],
//   theme: {
//     extend: {},
//   },
//   plugins: [],
// }

module.exports = {
    purge: [
      './public/**/*.html',
      './src/**/*.vue',
    ],
    darkMode: false, // or 'media' or 'class'
    theme: {
      extend: {backgroundImage: {
        'anhnen': "url('https://riofintech.vn/media/statics/backgrounds/rio-thumbnail.jpg')"
      }},
    },
    variants: {
      extend: {},
    },
    plugins: [] 
    
    
  }
  //cai dat giong o tren tutoriral nhung cai taiwind nay phai cua tailwintest
