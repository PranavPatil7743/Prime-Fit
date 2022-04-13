import React from 'react';
import { useState } from 'react';
import { useEffect } from "react/cjs/react.development";
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Logout from '../../screens/common/Logout';
//import  AllMembers from '';
//import PersonIcon from '@material-ui/icons/Person';


const UserProfile = () => {
  const [firstName, setfirstName] = useState('');
  const [lastName, setlastName] = useState('');
  const [email, setemail] = useState('');
  const [role, setrole] = useState('');
  const [password, setpassword] = useState('');
  const [phone, setphone] = useState('');

  // const history = useHistory();
  const { id } = useParams();


  const user = { firstName, lastName, email, role, password, phone };

  useEffect(() => {
    axios.get(id)
      .then(user => {
        setfirstName(user.data.firstName);
        setlastName(user.data.lastName);
        setemail(user.data.email);
        setrole(user.data.role);
        setpassword(user.data.password);
        setphone(user.data.phone);
      })
      .catch(error => {
        console.log('Something went wrong', error);
      })
  }, 


//   useEffect(() => {
//     console.log("User component is mounted");
//     getMember();

// } , []);


// const getMember = (id) => {
//   axios.get(url+"/users/user/id").then((response) => {
//       const result = response.data;
//       console.log(result);
//       if (result.status === "OK" ) {
//           setMember(result.response);
//       }else{
//           alert("users not found");
//       }
//   });
// }

  )
  return (
    
      <div  >
        <Logout/>
        <br /><br /><br /><br />
        <div className='navbar_sale'>
          <h3>
            {/* <PersonIcon fontSize='large' /> */}

            User Profile</h3>
          <br />
        </div>
        <hr />
        <br />
        <div>

          <table style={{ width: '80%', fontSize: '25px', fontFamily: 'serif' }} >
            <thead className="thead-dark">
              {/* <tr>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Password</th>
                <th>Role</th>
                <th>Phone</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              
               <tr>
                    <td>{user.firstName}</td>
                    <td>{user.lastName}</td>
                    <td>{user.email}</td>
                    <td>{user.password}</td>
                    <td>{user.role}</td>
                    <td>{user.phone}</td>
                    <td>
                     
                    </td>
                  </tr>
               
            </tbody> */}
              <tr>
                <th style={{ backgroundColor: '0a99af' }}>FirstName</th>
                <td>{user.firstName}</td>
              </tr>
              <tr>
                <th>LastName</th>
                <td>{user.lastName}</td>
              </tr>
              <tr>
                <th>Email</th>
                <td>{user.email}</td>
              </tr>
              <tr>
                <th>Role</th>
                <td>{user.role}</td>
              </tr>
              <tr>
                <th>Phone</th>
                <td>{user.phone}</td>
              </tr>
            </thead>
          </table>

        </div>
      </div>

    

  );
}

export default UserProfile;