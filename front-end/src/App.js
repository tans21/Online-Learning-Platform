import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import LogIn from './components/LogIn'; // Updated import statement
import SignUp from './components/SignUp';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './components/Home';
import Course from './components/Courses';
import AdminLogin from './components/AdminLogin';
import CourseCrud from './components/CourseCrud';


const App = () => {
  return (

    
    <Router>
      <div className="App">
        <Routes>
          <Route  path="/"      element={<Home />} />
          <Route  path="/login" element={<LogIn/>}/>
          <Route  path="/signup" element={<SignUp/>}/>
          <Route  path="/courses" element={<Course/>}/>
          <Route  path="/adminlogin" element={<AdminLogin/>}/>
          <Route  path="/managecourse" element={<CourseCrud/>}/>
          

        </Routes>
      </div>
    </Router>
  );
};

export default App;