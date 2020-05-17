import React,{Component} from 'react';
//import FirstComponent from './components/learning-examples/FirstComponent'
//import SecondComponent from './components/learning-examples/SecondComponent'
//import ThirdComponent from './components/learning-examples/ThirdComponent'
//import Counter from './components/counter/Counter'
import TodoApp from './components/todo/TodoApp'
//import logo from './logo.svg';
import './App.css';
import './bootstrap.css';
//import { render } from '@testing-library/react';

class App extends Component{
  render(){
    return(
      <div className="App">
        {/*<Counter />*/}
        <TodoApp></TodoApp>
       
      </div>
    );

  }
}


//class LearningComponent extends Component{
  //render(){
    //return(
      //<div className="App">
        //My First React
        //<FirstComponent></FirstComponent>
        //<SecondComponent></SecondComponent>
        //<ThirdComponent></ThirdComponent>
      //</div>
    //);

  //}
//}


 
export default App;
