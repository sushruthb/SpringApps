import axios from 'axios'
class HelloWorldService{

    executeHelloWorldService(){
        console.log('Executed Service')
        return axios.get('http://10.76.110.207:6262');
    }
}

export default new HelloWorldService()