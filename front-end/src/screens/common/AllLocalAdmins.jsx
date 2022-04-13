import React  from "react";
import { useState,useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { url } from "../../common/constant";
//import $ from "jquery";
import Logout from '../../screens/common/Logout';
import { useHistory } from "react-router-dom";

//import { useSelector } from "react-redux";

const AllLocalAdmins = () => {
    const [admins, setAdmin] = useState([]);
    const history = useHistory();

    //const isLogIn = useSelector((state) => state.isSignin);

    // if(isLogIn.status === false){
    //     alert('please signin first!!')
    //     history.push('/signin')
    //   }

    useEffect(() => {
        console.log("User component is mounted");
        getAdmin();
    
    } , []);

    const getAdmin = () => {
        axios.get(url+"/users/localadmins").then((response) => {
            const result = response.data;
            console.log(result);
            if (result.status === "OK" ) {
                setAdmin(result.response);
            }else{
                alert("users not found");
            }
        });
    }

    const deleteAdmin = (admin) => {
        console.log(admin.id);
        axios.delete(url+"/users/delete/"+admin.id).then((response) => {
            const result = response.data;
            if(result.status === "OK"){
                getAdmin();
            }else{
                alert("error while user deletion");
            }
        })
    }

    // $(document).ready(function(){
    //     $("#myInput").on("keyup", function() {
    //       var value = $(this).val().toLowerCase();
    //       $("#myTable tr").filter(function() {
    //         $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    //       });
    //     });
    //   });

    return(
        <div className="privacydiv">
             <Logout/>
            
             <Link to="/addlocaladmin" className="btn btn-warning"> Add Local-Admin </Link>
             
            <h1 align="center">All Local-Admins</h1> 
            <table className="table">
                <thead class="thead-dark">
                
                    <tr>
                        <th>Id</th>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>email</th>                       
                        <th>Phone No.</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody id="myTable"> 
                    {
                        admins.length >= 1 ? admins.map(admin => {
                            return(
                                <tr key={admin.id}>
                                    <td>{admin.id}</td>
                                    <td>{admin.firstName}</td>
                                    <td>{admin.lastName}</td>
                                    <td>{admin.email}</td>                                
                                    <td>{admin.phone}</td>
                                    <td>
                                        <button type="button" class="btn btn-danger" onClick={()=>{deleteAdmin(admin)}}>
                                           Delete
                                        </button>&nbsp;&nbsp;
                                        <button type="button" class="btn btn-light" onClick={()=>{
                                 history.push('/updatelocaladmin', {admins:admin}) 
                                }}>
                                           Edit
                                        </button>
                                    </td>
                                </tr>
                            )
                        }):''
                    }
                </tbody>
            </table>  
            <div >
             <Link to="/adminpage" className="btn btn-info" align="right"> Back </Link>
             </div>
            
        </div>
    )
}


export default AllLocalAdmins;