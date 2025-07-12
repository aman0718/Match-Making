import { assets } from "../assets/assets";


const Navbar = () =>{
    return(

        <nav 
            className=" fixed top-0 left-0 z-50 w-full  text-white shadow-lg px-8 py-4 flex items-center justify-between"
            style={{backgroundImage: "linear-gradient(to right, #f2ad73, #800080)"}}>

             {/* Left Section */}
            <div className="flex items-center space-x-8">
                {/* Logo or Title */}
                <img 
                    src={assets.logo} 
                    alt="logo" 
                    className="h-10 w-10 object-contain cursor-pointer"
                />
                <span className="text-2xl font-semibold text-blue-900 cursor-pointer">
                    Connect<span className="text-pink-600 cursor-pointer">Heart</span>
                </span>
            </div>

           
            {/* Navigation Links (optional) */}
            <div className="hidden md:flex space-x-8">
                <a href="/" className="text-white hover:text-yellow-400 font-medium">
                    Home
                </a>
                <a href="/discover" className="text-white hover:text-yellow-400 font-medium">
                    Discover
                </a>
                <a href="#" className="text-white hover:text-yellow-400 font-medium">
                    Messages
                </a>
                <a href="#" className="text-white hover:text-yellow-400 font-medium">
                    Profile
                </a>
            </div>

            {/* Right Section */}
            {/* Login Button */}
            <div className="hidden md:flex items-center space-x-4">
                <button 
                    className="px-4 py-2 rounded-full hover:bg-orange-400 hover:text-white transition font-semibold ">
                    Login
                </button>
            </div>
        </nav>

    );
}

export default Navbar;