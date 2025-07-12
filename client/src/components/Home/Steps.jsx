// src/components/HeroSection.jsx

import { HowItWorks } from "../../assets/assets";



const Steps = ({Steps}) => {

  return (
     <section className="bg-white py-16 px-6 md:px-20">
      <div className="max-w-6xl mx-auto text-center">
        <h2 className="text-3xl md:text-4xl font-bold mb-8 text-purple-400">
          How It Works
        </h2>
        <div className="grid md:grid-cols-3 gap-10">
          {HowItWorks.map((step, idx) => (
            <div
              key={idx}
              className="bg-gray-50 p-6 rounded-lg shadow-md hover:shadow-lg transition-shadow"
            >
              <div className="text-5xl mb-4">
                {step.icon || idx+1} {/* fallback icon if empty */}
              </div>
              <h3 className="text-xl font-semibold text-gray-800 mb-2">
                {step.title}
              </h3>
              <p className="text-gray-600">{step.description}</p>
            </div>
          ))}
        </div>
      </div>
    </section>

  );
};

export default Steps;
