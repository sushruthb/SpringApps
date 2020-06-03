
import React, { Component } from "react"

import moment from 'moment'
import {Formik, Form, Field, ErrorMessage} from 'formik'

class TodoComponent extends Component{
    constructor(props){
        super(props)
        this.state={

            id : this.props.match.params.id,
            description : "Learn Full stack",
            targetDate : moment(new Date()).format('YYYY-MM-DD')
        }

        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
    }
    validate(values){
        let errors={}
        if (!values.description){
            errors.description='Enter Description'
        }else if(values.description.length<5){
            errors.description='Description should be more than five characters'

        }
        
        if(!moment(values.targetDate).isValid()){
            errors.targetDate= 'Enter a valid target date'

        }
        console.log(values)
        return errors
    }
    onSubmit(values){
        console.log(values);

    }
    render(){
        let {description,targetDate}=this.state
        //let targetDate=this.state.targetDate
        return <div>
            <h1>Update Todo </h1>
            <div className="container">

                <Formik
                initialValues={{description ,targetDate }}
                onSubmit={this.onSubmit}
                validateOnChange={false}
                validateOnBlur={false}
                validate={this.validate}>

                    {
                    (props) =>(
                         <Form>
                             <ErrorMessage name="description" component="div" className="alert alert-warning" />
                             <ErrorMessage name="targetDate" component="div" className="alert alert-warning" />
                            <fieldset className="form-group">
                                <label>Description</label>
                                    <Field className="form-control" type="text" name="description"></Field>
                            </fieldset>
                            <fieldset className="form-group">
                                <label>Target Date</label>
                                    <Field className="form-control" type="date" name="targetDate"></Field>

                             </fieldset>
                             <button className="btn btn-success" type="submit">Save</button>
                         </Form>
                    )
                }
                </Formik>
            </div>
            
            </div>
        
    }
}

export default TodoComponent