import { FOOTER_CONSTANTS } from "../assets/assets";


const Footer = () =>{
    return (
         <footer className="w-full bg-blue-900 text-white py-4 ">
            <div className="container mx-auto flex justify-center space-x-6">
                {FOOTER_CONSTANTS.map((item, index) => (
                    <a 
                        key={index} 
                        href={item.url} 
                        target="_blank" 
                        rel="noopener noreferrer"
                        className="hover:opacity-75 transition duration-200"
                    >
                        <img src={item.logo} alt="social-icon" width={30} height={30} />
                    </a>
                ))}
            </div>
            <div className="text-center mt-4 text-sm text-gray-400">
                © {new Date().getFullYear()} amanlabs. All rights reserved.
            </div>
        </footer>
    )
}

export default Footer;