
import React, { Component } from "react"

import moment from 'moment'

class TodoComponent extends Component{
    constructor(props){
        super(props)
        this.state={

            id : 1,
            description : "Learn Full stack",
            targetDate : new Date()
        }
    }

    render(){

        return <div>Todo Component for -id {this.props.match.params.id}</div>
        
    }
}

export default TodoComponent