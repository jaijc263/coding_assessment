import './App.css';
import SignUpForm from './components/SignUpForm';
import { useState } from 'react';


const App= () => {

  const [values, setValues] = useState({
    firstname:"",
    lastname:"",
    npinum:"",
    business_address:"",
    tel_num:"",
    email:""
  });

  const inputs = [
    {
      id:1,
      name:"firstname",
      type:"text",
      placeholder:"First Name",
      errorMessage:"Minimum 3 character and No special characters or numbers allowed",
      label: "First Name",
      pattern: "^[a-zA-Z]{3,}$",
      required: true,
    },
    {
      id:2,
      name:"lastname",
      type:"text",
      placeholder:"Last Name",
      errorMessage:"Minimum 3 character and No special characters or numbers allowed",
      label: "Last Name",
      pattern: "^[a-zA-Z]{3,}$",
      required: true,
    },
    {
      id:3,
      name:"npinum",
      type:"text",
      placeholder:"NPI Number",
      label: "NPI Number",
      errorMessage:"only numbers allowed",
      pattern: "^[0-9]+$",
      required: true,
    },
    {
      id:4,
      name:"business_address",
      type:"text",
      placeholder:"Business Address",
      label: "Business Address",
      required: true,
    },
    {
      id:5,
      name:"tel_num",
      type:"text",
      placeholder:"Telephone Number",
      errorMessage:"only numbers allowed",
      pattern: "^[0-9]+$",
      label: "Telephone Number",
      required: true,
    },
    {
      id:6,
      name:"email",
      type:"email",
      placeholder:"Email address",
      errorMessage:"valid email is required",
      label: "Email address",
      required: true,
    },
  ]
  
  const handleSubmit = (e) => {
    e.preventDefault();
  };
  
  const onChange = (e) => {
      setValues({...values, [e.target.name]: e.target.value })
  };

  console.log(values);

  return (
    <div className='app'>
      
      <form onSubmit={handleSubmit}>
      <h1>Create User Account</h1>
        {
          inputs.map((input) => (
            <SignUpForm key={input.id} {...input} values={values[input.name]} onChange={onChange}/>
          ))
        }
        <button>Submit</button>
      </form>
    </div>
  );
};

export default App;
