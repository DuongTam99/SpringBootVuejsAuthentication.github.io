import axios from 'axios'
//import authHeader from './auth-header'
const API_URL = 'http://localhost:8080/test';
class UserService {
    getPublicContent () {
        return axios.get(API_URL+ '/all');

    }
    getUserBoard() {
        return axios.get(API_URL + '/user', {headers : {'Authorization':'Bearer '+JSON.parse(localStorage.getItem('user').accessToken)}
         //   authHeader()
         //   {'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0YW0wMDcyIiwiaWF0IjoxNjYxOTM5MzA3LCJleHAiOjE2NjE5NzUzMDd9.NpixFe-qppaPQbSduFEuex8W_g5ENr-ECfztICjYgf8'}
        }
    )}
    getModeratorBoard() {
        return axios.get(API_URL + '/mod', {headers : {'Authorization':'Bearer '+JSON.parse(localStorage.getItem('user').accessToken)}
            //authHeader()
        })
    }
    getAdminBoard() {
        return axios.get(API_URL + '/admin', {headers: {'Authorization':'Bearer '+JSON.parse(localStorage.getItem('user').accessToken)}
            //authHeader()
        })
    }

    }
export default new UserService();
//reset token,phan chia code header API,
