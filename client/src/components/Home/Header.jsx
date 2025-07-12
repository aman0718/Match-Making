import { assets } from "../../assets/assets";

const Header = () => {
  return (
        <div className="grid grid-cols-1 md:grid-cols-2 gap-12 items-center mb-20 px-4 md:px-10">
            {/* Left side: Video Banner */}
            <div className="order-2 md:order-1 flex justify-center">
                <div className="rounded-3xl overflow-hidden shadow-[0_25px_50px_-12px_rgba(255,105,180,0.3)]">
                    <video
                        src={assets.banner}
                        autoPlay
                        loop
                        muted
                        className="w-full max-w-[450px] md:max-w-[500px] h-auto object-cover"
                    />
                </div>
                {/* <div className="rounded-full w-full h-auto flex items-center justify-center">
                    <img src={assets.meme} alt="" />
                </div> */}
            </div>

            {/* Right side: Text content */}
            <div className="order-1 md:order-2 text-center md:text-left">
                <h1 className="text-4xl md:text-5xl font-extrabold mb-6 leading-snug bg-purple-400 text-transparent bg-clip-text">
                    Connect with <span className="text-orange-500">Intent.</span>
                    
                </h1>
              
                <p className="text-gray-700 text-lg md:text-xl mb-8 leading-relaxed max-w-xl">
                    Whether you're seeking love, marriage, or lifelong companionship,
                    we're here to help you find the match that truly understands you.
                </p>
                <a
                    href="/discover"
                    className="inline-block bg-orange-400 text-white px-7 py-3 rounded-full font-semibold shadow-lg hover:brightness-110 transition">
                    Start Matching
                </a>
            </div>
        </div>
  );
};

export default Header;
