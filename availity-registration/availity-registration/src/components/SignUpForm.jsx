import React from 'react'
import "./SignUpForm.css"
import { useState } from "react";

const SignUpForm = (props) => {
  const [focused, setFocused] = useState(false);
  const {label, errorMessage, onChange, id, ...inputProps} = props;

  const handleFocus = (e) => {
    setFocused(true);
  };

  return (
    <div className='signupform'>
      
      <label>{label}</label>
      <input {...inputProps} onChange={onChange} onBlur={handleFocus}
      
      focused={focused.toString()}/>
      <span>{errorMessage}</span>
    </div>
  )
}

export default SignUpForm