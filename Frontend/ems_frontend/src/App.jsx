import { BrowserRouter, Routes, Route } from 'react-router-dom'
import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeesComponent from './components/ListEmployeesComponent'
import EmployeeComponent from './components/EmployeeComponent'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />

        <Routes>
          {/* http;//locahost:3000/ */}
          <Route path='/' element={<ListEmployeesComponent />}></Route>

          {/* http;//locahost:3000/employees */}
          <Route path='/employees' element={<ListEmployeesComponent />}></Route>

          {/* http;//locahost:3000/add-employee */}
          <Route path='/add-employee' element={<EmployeeComponent />}></Route>

          {/* http;//locahost:3000/edit-employee/1 */}
          <Route path='/edit-employee/:id' element={<EmployeeComponent />}></Route>



        </Routes>

        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
