import { Toaster } from 'react-hot-toast';
import { Route, Routes } from 'react-router-dom';
import './App.css';
import Footer from './components/Footer';
import Navbar from './components/Menubar';
import Discover from './pages/Discover';
import Home from './pages/Home';

function App(){
  return (
    <div>
      <Navbar/>
      <Toaster/>
        <Routes>
          <Route path='/' element={<Home/>}/>
          <Route path='/discover' element={<Discover/>}/>
        </Routes>
        <Footer/>
    </div>
  );
}

export default App;
