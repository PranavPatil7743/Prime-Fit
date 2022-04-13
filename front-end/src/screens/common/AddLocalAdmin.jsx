import React from "react";

import { useState } from "react";
import axios from "axios";
import { url } from "../../common/constant";
import { useHistory } from "react-router-dom";
import {Link } from 'react-router-dom';
import Logout from '../../screens/common/Logout';


const AddAdmin = () => {
  const [firstName, setFname] = useState("");
  const [lastName, setLname] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
   const [userBranchId, setUserBranchId] = useState("");
  const [locality, setLocality] = useState("");
  const [city, setCity] = useState("");
  const [state, setState] = useState("");
  const [zipCode, setZipCode] = useState("");
  const [phone, setPhone] = useState("");
  const [role, setRole] = useState("");
  const history = useHistory();

  const addAdmin = () => {
    if (email === "" || password === "" || firstName === "" || lastName === "" || locality === "" || city === "" || state === "" || zipCode === "" || phone === "" ) {
      alert("fields cannot be left empty");
    } else {
      let data = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        password: password,
        // confirmPassword: confirmPassword,
        locality:locality,
        city:city,
        state:state,
        zipCode:zipCode,
        phone: phone,
        role:"LOCAL_ADMIN",
        // userBranchId:userBranchId
      };
      console.log(data);
      // SENDS DATA TO THE API

      axios.post(url+"/users/add/"+userBranchId, data).then((response) => {
        const result = response.data;
        if (result.status === "OK") {
          alert("successfully registered");
          history.push("/alllocaladmins");
        } else {
          alert("email already exist");
        }
      });

      
    }
  };

  return (
   
    <div className="privacydiv">
       <Logout/>

      
     
      <div className="form-group row">
        <label for="email5" className="col-sm-2 col-form-label" align='middle'>
          First Name
        </label>
        <div className="col-sm-3">
          <input
            type="text"
            className="form-control"
            id="fname"
            placeholder="First Name"
            onChange={(event) => {
              setFname(event.target.value);
            }}
            required
          />
        </div>
        <label for="email5" className="col-sm-2 col-form-label" align='middle'>
          Last Name
        </label>
        <div className="col-sm-3">
          <input
            type="text"
            className="form-control"
            id="lname"
            placeholder="last Name"
            onChange={(event) => {
              setLname(event.target.value);
            }}
            required
          />
        </div>
      </div>
      <div className="form-group row">
        <label for="email5" className="col-sm-2 col-form-label" align='middle'>
          Email
        </label>
        <div className="col-sm-8">
          <input
            type="email"
            className="form-control"
            id="email5"
            placeholder="Email"
            onChange={(event) => {
              setEmail(event.target.value);
            }}
            required
          />
        </div>
      </div>
      <div className="form-group row">
        <label for="password5" className="col-sm-2 col-form-label" align='middle'>
          Password
        </label>
        <div className="col-sm-8">
          <input
            type="password"
            className="form-control"
            id="password"
            placeholder="Password"
            onChange={(event) => {
              setPassword(event.target.value);
            }}
            required
          />
        </div>
      </div>
      
      <div className="form-group row">
        <label for="locality5" className="col-sm-2 col-form-label" align='middle'>
         Locality
        </label>
        <div className="col-sm-8">
          <input
            type="text"
            className="form-control"
            id="locality"
            placeholder="Locality"
            onChange={(event) => {
              setLocality(event.target.value);
            }}
            required
          />
        </div>
      </div>
      <div className="form-group row">
        <label for="city5" className="col-sm-2 col-form-label" align='middle'>
         City
        </label>
        <div className="col-sm-8">
          <input
            type="text"
            className="form-control"
            id="city"
            placeholder="City"
            onChange={(event) => {
              setCity(event.target.value);
            }}
            required
          />
        </div>
      </div>
      <div className="form-group row">
        <label for="state5" className="col-sm-2 col-form-label" align='middle'>
         State
        </label>
        <div className="col-sm-8">
          <input
            type="text"
            className="form-control"
            id="state"
            placeholder="State"
            onChange={(event) => {
              setState(event.target.value);
            }}
            required
          />
        </div>
      </div>
      <div className="form-group row">
        <label for="zipCode5" className="col-sm-2 col-form-label" align='middle'>
         Zipcode
        </label>
        <div className="col-sm-8">
          <input
            type="number"
            className="form-control"
            id="zipCode"
            placeholder="Zipcode"
            onChange={(event) => {
              setZipCode(event.target.value);
            }}
            required
          />
        </div>
      </div>
      <div className="form-group row">
        <label for="phone5" className="col-sm-2 " align='middle'>
          Contact Number
        </label>
        <div className="col-sm-8">
          <input
            type="number"
            className="form-control"
            id="phone"
            placeholder="phone number"
            onChange={(event) => setPhone(event.target.value)}
            required
          />
        </div>
      </div>

      <div className="form-group row">
        <label for="role5" className="col-sm-2 " align='middle'>
          Role
        </label>
        <div className="col-sm-8">
          <input
            type="text"
            className="form-control"
            id="role"
            disabled
            value="LOCAL_ADMIN"
            onChange={(event) => setRole(event.target.value)}
            required
          />
        </div>
      </div>
      <div className="form-group row">
        <label for="password5" className="col-sm-2 " align='middle'>
          Branch Id
        </label>
        <div className="col-sm-8">
          <input
            type="text"
            className="form-control"
            id="cnfpass"
            placeholder="Branch Id"
            onChange={(event) => {
              setUserBranchId(event.target.value);
            }}
            required
          />
        </div>
      </div>
      <div className="form-group row">
        <div className="col-sm-8 offset-sm-2">
          <div className="form-check">
            {/* <input className="form-check-input" type="checkbox" id="check5" /> */}
            {/* <label className="form-check-label" for="check5">
              By clicking register you agree with the terms and conditions.
            </label> */}
          </div>
        </div>
      </div>
      <div>
        <div className="col-sm-12 text-center">
          <button className="btn btn-primary" onClick={addAdmin}>
            Add Admin
          </button>&nbsp;&nbsp;
          <Link to="/alllocaladmins" className="btn btn-info" align="right"> Back </Link>
        </div>
       
      </div>
    </div>
  );
};
export default AddAdmin;
