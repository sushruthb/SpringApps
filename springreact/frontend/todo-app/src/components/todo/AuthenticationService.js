import axios from 'axios';



class AuthenticationService{
    executeBasicAuthenticationService(username,password){
        return axios.get("http://10.76.110.207:6262/basicauth",
        
            {
                headers:{authorization:this.createBasicAuthToken(username,password)}})
    }

    executeJWTAuthenticationService(username,password){
        return axios.post("http://10.76.110.207:6262/authenticate",
                username,
                password
        
           )
    }

    createBasicAuthToken(username,password){
        return 'Basic ' + window.btoa(username + ":" + password)
    }
    
    createJWTToken(token){
        return 'Bearer ' + token
    }
    registerSuccessfulLogin(username,password){

        sessionStorage.setItem('authenticatedUser',username);
        this.setupAxiosInterceptors(this.createBasicAuthToken(username,password))
    }

    registerSuccessfulLoginForJwt(username,token){

        sessionStorage.setItem('authenticatedUser',username);
        this.setupAxiosInterceptors(this.createJWTToken(token))
    }

    logout(){
        sessionStorage.removeItem('authenticatedUser');

    }

    isUserLoggedIn(){
        let user = sessionStorage.getItem('authenticatedUser')
        if(user===null) return false
        return true
    }

    
    getUserLoggedInUserName(){
        let user = sessionStorage.getItem('authenticatedUser')
        if(user===null) return ''
        return user
    }

    setupAxiosInterceptors(basicAuthHeader){
      
        axios.interceptors.request.use(
            (config) =>  {
                if(this.isUserLoggedIn()){

                    config.headers.authorization = basicAuthHeader
                                                            
                }
                return config
            }
        )
    }
    }



export default  new AuthenticationService()