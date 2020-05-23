import axios from 'axios'
class HelloWorldService{

   // executeHelloWorldService(){
   //     console.log('Executed Service')
  //      return axios.get('http://10.76.110.207:6262/')
 //   }

  //  executeHelloWorldBeanService(){
 //       console.log('Executed Service')
 //       return axios.get('http://10.76.110.207:6262/hello-world-bean')
 //   }

    executeHelloWorldBeanPathVariableService(name){
        console.log('Executed Service')
        return axios.get(`http://10.76.110.207:6262/hello-world-bean/${name}`)
    }

    }



export default new HelloWorldService()