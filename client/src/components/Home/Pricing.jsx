import { Plans } from "../../assets/assets";


const Pricing = () =>{
    return(
    <section className="bg-gray-100 py-16 px-6 md:px-20">
      <div className="max-w-6xl mx-auto text-center">
        <h2 className="text-3xl md:text-4xl font-bold mb-8 text-purple-400">
          Pricing Plans
        </h2>
        <p className="text-pink-600 mb-12">
          Choose a plan that suits your relationship journey.
        </p>

        <div className="grid md:grid-cols-3 gap-10">
          {Plans.map((plan, idx) => (
            <div
              key={idx}
              className="bg-white p-8 rounded-xl shadow-md border hover:shadow-lg transition-shadow"
            >
              <h3 className="text-2xl font-semibold text-gray-800 mb-4">
                {plan.name}
              </h3>
              <div className="text-3xl font-bold text-indigo-600 mb-6">
                {plan.price}
              </div>
              <ul className="text-gray-700 space-y-3 mb-6 text-left">
                {plan.features.map((feature, i) => (
                  <li key={i}>✅ {feature}</li>
                ))}
              </ul>
              <button className="bg-indigo-600 text-white px-6 py-2 rounded-lg hover:bg-indigo-700 transition">
                Select Plan
              </button>
            </div>
          ))}
        </div>
      </div>
    </section>

    )
}

export default Pricing;