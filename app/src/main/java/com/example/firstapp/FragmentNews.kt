package com.example.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.adapters.NewsAdapter
import com.example.firstapp.databinding.FragmentNewsBinding
import com.example.firstapp.models.ItemDecoration
import com.example.firstapp.models.NewsItem

class FragmentNews : Fragment() {
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)

        val newsList = listOf(
            NewsItem("Мы открылись!", "Познакомьтесь с городом на Волге, отдыхая в нашем современном и уютном", "https://i.pinimg.com/originals/2d/8f/b6/2d8fb6d52043fee54192591db35a01e7.png"),
            NewsItem("Зимнее предложение!", "Скидка 15% на проживание в любом номере", "https://blog.ostrovok.ru/wp-content/uploads/2012/02/download.jpg"),
            NewsItem("Подарок для него и для нее", "Подарите друг другу праздник!", "https://avatars.mds.yandex.net/get-kinopoisk-image/1900788/d13d1530-79cf-4022-a850-da71a1d91e54/1920x"),
            NewsItem("Новая категория номеров", "Появились номера класса люкс", "https://cdn.audleytravel.com/840/600/79/496939-harbour-view-room-mandarin-oriental.jpg"),
            NewsItem("Ресторан Brauplatz", "Ресторан на территории отеля", "https://cdn1.flamp.ru/bedeaa118cf546c9d6db4f4b6c787be8.jpeg"),
            NewsItem("Заказ в номер", "У нас вы можете сделать заказ не выходя из номера!", "https://avatars.mds.yandex.net/i?id=890cab95f753db6e0e9272048c44368e_l-7009603-images-thumbs&n=13"),
            NewsItem("Скидка 18%", "Скидка при раннем бронировании", "https://calculife.com/wp-content/uploads/18-percent-vat.jpg"),
            NewsItem("Бесплатный WiFi", "На территории всех отелей бесплатный доступ к сети Wifi", "https://avatars.mds.yandex.net/i?id=bd0cd3e8e8cd6bcdd6381673e77adc5e3de40fa18450b9a4-12640484-images-thumbs&n=13"),
            NewsItem("Что такое Cosmos?", "Подробнее о нашей сети", "https://i.pinimg.com/originals/2d/8f/b6/2d8fb6d52043fee54192591db35a01e7.png"),
            NewsItem("Выгодная командировка с завтраком и ужином", "Период проживания: не ограничено. Завтрак Шведский стол и комплексный ужин по меню в стоимость включены.", "https://via.placeholder.com/300")
        )

        binding.newsList.layoutManager = LinearLayoutManager(requireContext())
        binding.newsList.adapter = NewsAdapter(newsList)
        binding.newsList.addItemDecoration(ItemDecoration(10))

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}