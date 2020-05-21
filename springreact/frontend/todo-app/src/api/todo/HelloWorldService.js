import axios from 'axios'
class HelloWorldService{

    executeHelloWorldService(){
        console.log('Executed Service')
        return axios.get('http://localhost:6262/');
    }
}

export default new HelloWorldService()