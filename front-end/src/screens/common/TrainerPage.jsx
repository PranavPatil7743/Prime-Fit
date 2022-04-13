import React from 'react'
import { Link } from "react-router-dom";
import Logout from '../../screens/common/Logout';
import {useSelector} from 'react-redux';
import {useHistory} from 'react-router-dom';

const  TrainerPage=()=> {

  const history=useHistory();
  const isSignin = useSelector((state) => state.isSignin);

  console.log("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  console.log(isSignin.user);

  if(isSignin.status === false){
    alert('please signin first!!')
    history.push('/login')
  }
  return (
    <div className="privacydiv">
        <Logout/>
        <hr/>
        <div align="center" className="admin-page">
        Trainer Page
        </div>
        <hr/>
        <hr/>
        <hr/>
        <hr/>
        <hr/>
        <hr/>

        
        <Link to="/trainers">   <a className="block" href=" ">          Trainers        </a>      </Link>

      <Link to="/branches">   <a className="block" href=" ">          Branches        </a>      </Link>      
        

      <Link to="/packages"><a className="block" href=" ">          Packages        </a>      </Link>

      <Link to="/profilelocal"><a className="block" href=" ">          Profile        </a>      </Link>
        <hr/>
        <hr/>
        <hr/> 
        

       


{/* <button type="button" class="btn btn-primary"> <Link to="/allmembers"> Members </Link></button>
<button type="button" class="btn btn-secondary">Secondary</button>
<button type="button" class="btn btn-success">Success</button>
<button type="button" class="btn btn-danger">Danger</button>
<button type="button" class="btn btn-warning">Warning</button>
<button type="button" class="btn btn-info">Info</button>
<button type="button" class="btn btn-light">Light</button>
<button type="button" class="btn btn-dark">Dark</button>

<button type="button" class="btn btn-link">Link</button> */}
    </div>
  )
}
export default TrainerPage