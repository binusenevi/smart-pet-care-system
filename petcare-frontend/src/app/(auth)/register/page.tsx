"use client";

import React, { useState } from 'react';
import { UserPlus, Mail, Lock, User, Briefcase, Loader2 } from 'lucide-react';
import api from '@/services/api';
import { useRouter } from 'next/navigation';

export default function RegisterPage() {

  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    role: 'PET_OWNER'
  });

  const [isLoading, setIsLoading] = useState(false);
  const [message, setMessage] = useState({ type: '', text: '' });
  const router = useRouter();

  const handleRegister = async (e: React.FormEvent) => {
    e.preventDefault();
    setIsLoading(true);
    setMessage({ type: '', text: '' });

    try {

      const response = await api.post('/auth/register', formData);

      setMessage({
        type: 'success',
        text: 'Registration successful! Now you can login.'
      });


      setTimeout(() => router.push('/login'), 2000);

    } catch (err: any) {
      console.error("Registration Error:", err);
      setMessage({
        type: 'error',
        text: err.response?.data?.message || "Registration failed. Please check Backend or CORS settings."
      });
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-50 px-4 py-12">
      <div className="max-w-md w-full space-y-8 bg-white p-10 rounded-2xl shadow-xl">
        <div className="text-center">
          <div className="mx-auto h-16 w-16 bg-green-100 rounded-full flex items-center justify-center">
            <UserPlus className="h-8 w-8 text-green-600" />
          </div>
          <h2 className="mt-6 text-3xl font-extrabold text-gray-900">Create Account</h2>
          <p className="mt-2 text-sm text-gray-600">Join the PetCare community today</p>
        </div>

        {/* Success/Error Message Display */}
        {message.text && (
          <div className={`px-4 py-3 rounded-lg text-sm text-center ${
            message.type === 'success' ? 'bg-green-50 text-green-600 border border-green-200' : 'bg-red-50 text-red-600 border border-red-200'
          }`}>
            {message.text}
          </div>
        )}

        <form className="mt-8 space-y-4" onSubmit={handleRegister}>
          <div className="space-y-4 text-gray-700">
            {/* Full Name */}
            <div className="relative">
              <User className="absolute left-3 top-3 h-5 w-5 text-gray-400" />
              <input
                type="text"
                required
                className="pl-12 w-full py-3 border border-gray-300 rounded-lg focus:ring-blue-500 focus:border-blue-500 transition-all"
                placeholder="Full Name"
                value={formData.name}
                onChange={(e) => setFormData({...formData, name: e.target.value})}
              />
            </div>

            {/* Email */}
            <div className="relative">
              <Mail className="absolute left-3 top-3 h-5 w-5 text-gray-400" />
              <input
                type="email"
                required
                className="pl-12 w-full py-3 border border-gray-300 rounded-lg focus:ring-blue-500 focus:border-blue-500 transition-all"
                placeholder="Email address"
                value={formData.email}
                onChange={(e) => setFormData({...formData, email: e.target.value})}
              />
            </div>

            {/* Password */}
            <div className="relative">
              <Lock className="absolute left-3 top-3 h-5 w-5 text-gray-400" />
              <input
                type="password"
                required
                className="pl-12 w-full py-3 border border-gray-300 rounded-lg focus:ring-blue-500 focus:border-blue-500 transition-all"
                placeholder="Password"
                value={formData.password}
                onChange={(e) => setFormData({...formData, password: e.target.value})}
              />
            </div>

            {/* Role Selection - Backend එකට ගැලපෙන values */}
            <div className="relative">
              <Briefcase className="absolute left-3 top-3 h-5 w-5 text-gray-400" />
              <select
                className="pl-12 w-full py-3 border border-gray-300 rounded-lg focus:ring-blue-500 focus:border-blue-500 bg-white transition-all"
                value={formData.role}
                onChange={(e) => setFormData({...formData, role: e.target.value})}
              >
                <option value="PET_OWNER">Pet Owner</option>
                <option value="DOCTOR">Veterinary Doctor</option>
                <option value="ADMIN">Administrator</option>
              </select>
            </div>
          </div>

          <button
            type="submit"
            disabled={isLoading}
            className="w-full flex justify-center py-3 px-4 border border-transparent rounded-lg text-white bg-blue-600 hover:bg-blue-700 transition-all disabled:opacity-50 font-semibold"
          >
            {isLoading ? <Loader2 className="animate-spin h-5 w-5" /> : "Sign Up"}
          </button>
        </form>

        <p className="text-center text-sm text-gray-600">
          Already have an account? <a href="/login" className="font-medium text-blue-600 hover:text-blue-500">Log in</a>
        </p>
      </div>
    </div>
  );
}