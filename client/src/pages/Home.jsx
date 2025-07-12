import Header from "../components/Home/Header";
import Pricing from "../components/Home/Pricing";
import Steps from "../components/Home/Steps";


const Home =() =>{
    return (

        <div className="pt-50">
            {/* <HeroSection/> */}
            <Header/>
            <Steps/>
            <Pricing/>
        </div>
       
    )
}

export default Home;