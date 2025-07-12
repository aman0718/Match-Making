import { profiles } from "../../assets/assets";
import ProfileCard from "../Profile/ProfileCard";


const Profiles =() =>{
    return (
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8 mt-10 px-4 mb-10 m-2 rounded-lg border-1 shadow-lg bg-gray-100">
            {profiles.map((profile, index) => (
                <ProfileCard key={index} profile={profile} />
            ))}
        </div>
    )
}

export default Profiles;