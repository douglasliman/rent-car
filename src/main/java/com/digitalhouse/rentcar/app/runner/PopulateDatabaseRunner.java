package com.digitalhouse.rentcar.app.runner;

import com.digitalhouse.rentcar.domain.entity.*;
import com.digitalhouse.rentcar.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class PopulateDatabaseRunner implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final ProductRespository productRespository;
    private final CityRepository cityRepository;
    private final ImageRepository imageRepository;
    private final FeatureRepository featureRepository;
    private  final UserRepository userRepository;
    private  final BookingRepository bookingRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public PopulateDatabaseRunner(CategoryRepository categoryRepository, ProductRespository productRespository,
                                  CityRepository cityRepository, ImageRepository imageRepository, FeatureRepository featureRepository, UserRepository userRepository, BookingRepository bookingRepository) {
        this.categoryRepository = categoryRepository;
        this.productRespository = productRespository;
        this.cityRepository = cityRepository;
        this.imageRepository = imageRepository;
        this.featureRepository = featureRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //------------------------------------------------------------------------

        City saoPaulo = new City();
        City curitiba = new City();
        City portoAlegre = new City();
        City sumare = new City();

        saoPaulo.setName("São Paulo");
        saoPaulo.setState("São Paulo");
        saoPaulo.setCountry("Brasil");

        curitiba.setName("Curitiba");
        curitiba.setState("Paraná");
        curitiba.setCountry("Brasil");

        portoAlegre.setName("Porto Alegre");
        portoAlegre.setState("Rio Grande do Sul");
        portoAlegre.setCountry("Brasil");

        sumare.setName("Sumaré");
        sumare.setState("São Paulo");
        sumare.setCountry("Brasil");

        cityRepository.saveAll(List.of(saoPaulo, curitiba, portoAlegre, sumare));

        //------------------------------------------------------------------------



        Feature cambioAutomatico = new Feature();
        Feature cambioManual = new Feature();
        Feature combustivelGasolina = new Feature();
        Feature combustivelAlcool = new Feature();
        Feature combustivelFlex = new Feature();
        Feature combustivelEletrico = new Feature();
        Feature kmIncluidaIlimitados = new Feature();
        Feature kmIncluida200 = new Feature();
        Feature kmIncluida300 = new Feature();
        Feature kmIncluida400 = new Feature();
        Feature gps = new Feature();
        Feature duasPortas = new Feature();
        Feature tresPortas = new Feature();
        Feature cincoPortas = new Feature();
        Feature kmCargaTotal300km = new Feature();
        Feature cabosCarregamento = new Feature();
        Feature doisAssentos = new Feature();
        Feature cincoAssentos = new Feature();
        Feature umaBagagem = new Feature();
        Feature duasBagagens = new Feature();

        cambioAutomatico.setName("Automático");
        cambioAutomatico.setUrl("https://imgur.com/F2PD61s.png");
        cambioManual.setName("Manual");
        cambioManual.setUrl("https://imgur.com/jufkX5b.png");
        combustivelGasolina.setName("Gasolina");
        combustivelGasolina.setUrl("https://imgur.com/nbJ1Y28.png");
        combustivelAlcool.setName("Alcool");
        combustivelAlcool.setUrl("https://imgur.com/nbJ1Y28.png");
        combustivelFlex.setName("Flex");
        combustivelFlex.setUrl("https://imgur.com/nbJ1Y28.png");
        combustivelEletrico.setName("Elético");
        combustivelEletrico.setUrl("https://imgur.com/b2DiHm1.png");
        kmIncluidaIlimitados.setName("Km ilimitados");
        kmIncluidaIlimitados.setUrl("https://imgur.com/8Vd7RlC.png");
        kmIncluida200.setName("Incl. 200 km");
        kmIncluida200.setUrl("https://imgur.com/8Vd7RlC.png");
        kmIncluida300.setName("Incl. 300 km");
        kmIncluida300.setUrl("https://imgur.com/8Vd7RlC.png");
        kmIncluida400.setName("Incl. 400 km");
        kmIncluida400.setUrl("https://imgur.com/8Vd7RlC.png");
        gps.setName("GPS incl.");
        gps.setUrl("https://imgur.com/npfcVtJ.png");

        duasPortas.setName("2 portas");
        duasPortas.setUrl("https://imgur.com/RRCeGwO.png");

        tresPortas.setName("3 portas");
        tresPortas.setUrl("https://imgur.com/RRCeGwO.png");

        cincoPortas.setName("5 portas");
        cincoPortas.setUrl("https://imgur.com/RRCeGwO.png");

        kmCargaTotal300km.setName("~300 km com carga total");
        kmCargaTotal300km.setUrl("https://i.imgur.com/GN6NRFm.png");

        cabosCarregamento.setName("Cabo de carregamento incl.");
        cabosCarregamento.setUrl("https://imgur.com/Cm1iDX0.png");

        doisAssentos.setName("2 assento");
        doisAssentos.setUrl("https://i.imgur.com/o2OQTZn.png");
        cincoAssentos.setName("5 assento");
        cincoAssentos.setUrl("https://i.imgur.com/o2OQTZn.png");

        umaBagagem.setName("1 bagagem");
        umaBagagem.setUrl("https://imgur.com/9kjJFnn.png");
        duasBagagens.setName("2 bagagens");
        duasBagagens.setUrl("https://imgur.com/9kjJFnn.png");

        featureRepository.saveAll(List.of(cambioAutomatico, cambioManual, combustivelGasolina, combustivelAlcool, combustivelFlex, combustivelEletrico,
                kmIncluidaIlimitados, kmIncluida200, kmIncluida300, kmIncluida400, gps, duasPortas, tresPortas, cincoPortas, kmCargaTotal300km,
                cabosCarregamento, doisAssentos, cincoAssentos, umaBagagem, duasBagagens));

        //------------------------------------------------------------------------

        Image poloImg = new Image();
        Image clioImg = new Image();
        Image p308Img = new Image();
        Image a1Img = new Image();
        Image f500Img = new Image();
        Image picantoImg = new Image();
        Image tucsonImg = new Image();
        Image capturImg = new Image();
        Image bmw1Img = new Image();
        Image tiguanImg = new Image();
        Image q3Img = new Image();
        Image gleImg = new Image();
        Image eClassImg = new Image();
        Image bmw7Img = new Image();
        Image carreraImg = new Image();
        Image caymanImg = new Image();
        Image rroverSportImg = new Image();
        Image rroverJLRImg = new Image();
        Image teslaYImg = new Image();
        Image mbEqsImg = new Image();
        Image bmwIxImg = new Image();
        Image zoeImg = new Image();
        Image id4Img = new Image();
        Image c4Img = new Image();

        poloImg.setTitle("Imagem VW Polo");
        poloImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/vw-polo-5d-weiss-2020.png");

        clioImg.setTitle("Imagem Renault Clio");
        clioImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/renault-clio-5d-schwarz-2020.png");

        p308Img.setTitle("Imagem Peugeout 308");
        p308Img.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/peugeot-308-5d-black-2021.png");

        a1Img.setTitle("Imagem Audi A1");
        a1Img.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/audi-a1-sportback-gelb-2019.png");

        f500Img.setTitle("Imagem Fiat 500");
        f500Img.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/fiat-500-2d-weiss-2020.png");

        picantoImg.setTitle("Imagem Kia Picanto");
        picantoImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/kia-picanto-5d-silver-2023.png");

        tucsonImg.setTitle("Imagem Hyundai Tucson");
        tucsonImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/hyundai-tucson-suv-bronze-2021.png");

        capturImg.setTitle("Imagem Renault Captur");
        capturImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/renault-captur-5d-blau-2020.png");

        bmw1Img.setTitle("Imagem BMW 1");
        bmw1Img.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/bmw-1er-5d-grau-2020.png");

        tiguanImg.setTitle("Imagem Tiguan");
        tiguanImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/bmw-1er-5d-grau-2020.png");

        q3Img.setTitle("Imagem Audi Q3");
        q3Img.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/audi-q3-5d-silber-2019.png");

        gleImg.setTitle("Imagem MB Gle");
        gleImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/mb-gle-5d-schwarz-2019.png");

        eClassImg.setTitle("Imagem E-Class");
        eClassImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/mb-e-class-4d-blue-2021.png");

        bmw7Img.setTitle("Imagem BMW 7");
        bmw7Img.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/bmw-7-4d-silver-2021.png");

        carreraImg.setTitle("Imagem Porche 911");
        carreraImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/bmw-7-4d-silver-2021.png");

        caymanImg.setTitle("Imagem Cayman");
        caymanImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/porsche-cayman-2d-grau-2018.png");

        rroverSportImg.setTitle("Imagem Range Rover Sport");
        rroverSportImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/land-rover-range-rover-sport-5d-suv-grey-2022.png");

        rroverJLRImg.setTitle("Imagem Range Rover JLR");
        rroverJLRImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/land-rover-range-rover-5d-JLR-gold-2023.png");

        teslaYImg.setTitle("Imagem Tesla Y");
        teslaYImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/tesla-y-4d-suv-weiss-2021.png");

        mbEqsImg.setTitle("Imagem MB EQS");
        mbEqsImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/mb-eqs-5d-silver-2022.png");

        bmwIxImg.setTitle("Imagem BMW iX");
        bmwIxImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/bmw-iX-4d-suv-grey-2021.png");

        zoeImg.setTitle("Imagem Renault Zoe");
        zoeImg.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/renault-zoe-5d-weiss-2020.png");

        id4Img.setTitle("Imagem VW Id4");
        id4Img.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/vw-id4-suv-4d-white-2022.png");

        c4Img.setTitle("Imagem Citroen C4");
        c4Img.setUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/citroen-c4-5d-blue-2021.png");

        imageRepository.saveAll(List.of(poloImg, clioImg, p308Img, a1Img, f500Img, picantoImg, tucsonImg, capturImg, bmw1Img, tiguanImg, q3Img, gleImg
                , eClassImg,bmw7Img, carreraImg, caymanImg, rroverSportImg, rroverJLRImg, teslaYImg, mbEqsImg, bmwIxImg, zoeImg, id4Img, c4Img));

        //------------------------------------------------------------------------

        Category suv = new Category();
        Category eletric = new Category();
        Category luxury = new Category();
        Category popularCar = new Category();

        suv.setQualification("SUV");
        suv.setDescription("Os carros dessa categoria costumam ser reconhecidos por apresentarem porte robusto, interior espaçoso e por transitar com excelente desempenho na cidade ou no off-road");
        suv.setImageUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/bmw-1er-5d-grau-2020.png");

        eletric.setQualification("Elétrico");
        eletric.setDescription("Carros elétricos não são movidos a base de combustão, e são exelentes para quem se preocupa meio-ambiente");
        eletric.setImageUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/tesla-y-4d-suv-weiss-2021.png");

        luxury.setQualification("Luxo");
        luxury.setDescription("O termo luxo é usado para categorizar veículos que estão equipados com melhores capacidades de desempenho, interiores luxuosos e todos os últimos recursos de segurança e tecnologia");
        luxury.setImageUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/mb-e-class-4d-blue-2021.png");

        popularCar.setQualification("Popular");
        popularCar.setDescription("Esses carros são populares por uma variedade de razões, incluindo seu preço acessível, sua confiabilidade e seu bom desempenho. Eles também são frequentemente equipados com uma variedade de recursos modernos, como sistemas de segurança e entretenimento.");
        popularCar.setImageUrl("https://www.sixt.com/fileadmin2/files/global/user_upload/fleet/png/350x200/renault-clio-5d-schwarz-2020.png");

        categoryRepository.saveAll(List.of(suv, eletric, luxury, popularCar));

        //------------------------------------------------------------------------

        Product polo = new Product();
        Product clio = new Product();
        Product p308 = new Product();
        Product a1 = new Product();
        Product f500 = new Product();
        Product picanto = new Product();
        Product tucson = new Product();
        Product captur = new Product();
        Product bmw1 = new Product();
        Product tiguan = new Product();
        Product q3 = new Product();
        Product gle = new Product();
        Product eClass = new Product();
        Product bmw7 = new Product();
        Product carrera = new Product();
        Product cayman = new Product();
        Product rroverSport = new Product();
        Product rroverJLR = new Product();
        Product teslaY = new Product();
        Product mbEqs = new Product();
        Product bmwIx = new Product();
        Product zoe = new Product();
        Product id4 = new Product();
        Product c4 = new Product();

        polo.setName("VW Polo 5P");
        polo.setDescription("O VW Polo é uma opção excepcional para quem busca um carro versátil e elegante. Com um design moderno e atraente, o Polo oferece mais do que apenas uma aparência sofisticada. Este veículo é a personificação da eficiência e desempenho, combinando tecnologia inovadora com um interior espaçoso e confortável.");
        polo.setPrice("R$ 50,00");
        polo.setFeatures(Set.of(cambioManual, combustivelFlex ,kmIncluida200, cincoPortas, cincoAssentos, duasBagagens));
        polo.setCategory(popularCar);
        polo.setCity(saoPaulo);
        polo.setImages(Set.of(poloImg));

        clio.setName("Renault Clio 5P");
        clio.setDescription("O Renault Clio  é mais do que um simples veículo; é uma declaração de estilo e funcionalidade. Este carro é projetado para aqueles que valorizam não apenas o desempenho na estrada, mas também a estética e a praticidade em cada detalhe.");
        clio.setPrice("R$ 60,00");
        clio.setFeatures(Set.of(cambioManual, combustivelFlex, kmIncluida200, cincoPortas, cincoAssentos, duasBagagens));
        clio.setCategory(popularCar);
        clio.setCity(curitiba);
        clio.setImages(Set.of(clioImg));

        p308.setName("Peugeot 308 5D");
        p308.setDescription("O Peugeot 308 5D é muito mais do que um veículo; é uma expressão de elegância e desempenho dinâmico. Este carro combina estilo refinado, tecnologia avançada e uma experiência de condução emocionante, tornando-o uma escolha excepcional para aqueles que buscam sofisticação e inovação em cada viagem.");
        p308.setPrice("R$ 60,00");
        p308.setFeatures(Set.of(cambioAutomatico, combustivelFlex, kmIncluida200, cincoPortas, cincoAssentos, duasBagagens));
        p308.setCategory(popularCar);
        p308.setCity(portoAlegre);
        p308.setImages(Set.of(p308Img));

        a1.setName("Audi A1 Sportback 2P");
        a1.setDescription("O Audi A1 Sportback  é um carro que une estilo e desempenho em uma experiência de condução única. Com design sofisticado, tecnologia avançada e características que impressionam, este veículo é uma escolha para quem busca um toque de luxo em suas jornadas.");
        a1.setPrice("R$ 80,00");
        a1.setFeatures(Set.of(cambioAutomatico, combustivelGasolina, kmIncluida200, duasPortas, cincoAssentos, umaBagagem));
        a1.setCategory(popularCar);
        a1.setCity(sumare);
        a1.setImages(Set.of(a1Img));

        f500.setName("Fiat 500 2P");
        f500.setDescription("O Fiat  é um automóvel que transcende a mera funcionalidade, representando uma síntese inigualável entre estilo icônico e praticidade. Este veículo se destaca como uma escolha popular para aqueles que procuram eficiência urbana aliada a um design diferenciado e marcante.");
        f500.setPrice("R$ 50,00");
        f500.setFeatures(Set.of(cambioAutomatico, combustivelGasolina, kmIncluida200, duasPortas, cincoAssentos, umaBagagem));
        f500.setCategory(popularCar);
        f500.setCity(saoPaulo);
        f500.setImages(Set.of(f500Img));

            picanto.setName("Kia Picanto ");
            picanto.setDescription("O Kia Picanto é um veículo que redefine a experiência de dirigir, proporcionando um equilíbrio perfeito entre eficiência, estilo e inovação. Como uma opção compacta, este carro é projetado para oferecer praticidade na condução urbana, sem comprometer o conforto e a modernidade.");
        picanto.setPrice("R$ 40,00");
        picanto.setFeatures(Set.of(cambioManual, combustivelFlex, kmIncluida200, cincoPortas, cincoAssentos, duasBagagens));
        picanto.setCategory(popularCar);
        picanto.setCity(curitiba);
        picanto.setImages(Set.of(picantoImg));

        tucson.setName("Hyundai Tucson 5P");
        tucson.setDescription("O Hyundai Tucson é um veículo que vai além das expectativas, oferecendo uma combinação única de desempenho robusto, conforto excepcional e design contemporâneo. Como um SUV versátil, o Tucson se destaca como uma opção que une elegância e funcionalidade em cada detalhe.");
        tucson.setPrice("R$ 100,00");
        tucson.setFeatures(Set.of(cambioAutomatico, combustivelFlex, kmIncluida300, gps, cincoPortas, cincoAssentos, duasBagagens));
        tucson.setCategory(suv);
        tucson.setCity(portoAlegre);
        tucson.setImages(Set.of(tucsonImg));

        captur.setName("Renault Captur 5D");
        captur.setDescription("O Renault Captur 5D é um carro que transcende as expectativas, oferecendo um equilíbrio excepcional entre estilo contemporâneo, desempenho eficiente e versatilidade funcional. Este veículo é projetado para aqueles que buscam uma experiência de condução sofisticada e adaptável às suas necessidades diárias.");
        captur.setPrice("R$ 120,00");
        captur.setFeatures(Set.of(cambioAutomatico, combustivelFlex, kmIncluida300, gps, cincoPortas, cincoAssentos, duasBagagens));
        captur.setCategory(suv);
        captur.setCity(sumare);
        captur.setImages(Set.of(capturImg));

        bmw1.setName("BMW 1 Series 5P");
        bmw1.setDescription("O BMW 1 Series é a personificação da excelência automotiva, oferecendo uma fusão perfeita entre desempenho esportivo, luxo refinado e inovação tecnológica. Este veículo eleva a experiência de condução a um nível superior, proporcionando aos entusiastas automotivos uma jornada única e emocionante.");
        bmw1.setPrice("R$ 150,00");
        bmw1.setFeatures(Set.of(cambioAutomatico, combustivelGasolina, kmIncluida300, gps, cincoPortas, cincoAssentos, duasBagagens));
        bmw1.setCategory(suv);
        bmw1.setCity(saoPaulo);
        bmw1.setImages(Set.of(bmw1Img));

        tiguan.setName("VW Tiguan 5P");
        tiguan.setDescription("O VW Tiguan é mais do que um simples veículo; é uma jornada de descoberta, combinando versatilidade, desempenho e elegância em um pacote cativante. Este SUV redefine a experiência de condução, proporcionando conforto e confiança em todas as aventuras.");
        tiguan.setPrice("R$ 120,00");
        tiguan.setCategory(suv);
        tiguan.setFeatures(Set.of(cambioAutomatico, combustivelFlex, kmIncluida300, gps, cincoPortas, cincoAssentos, duasBagagens));
        tiguan.setCity(curitiba);
        tiguan.setImages(Set.of(tiguanImg));

        q3.setName("Audi Q3 5P");
        q3.setDescription("O Audi Q3  é uma expressão de luxo e desempenho, oferecendo uma experiência de condução que transcende as expectativas. Este SUV combina sofisticação, inovação e versatilidade para proporcionar uma jornada única e emocionante em todas as estradas.");
        q3.setPrice("R$ 150,00");
        q3.setFeatures(Set.of(cambioAutomatico, combustivelGasolina, kmIncluida300, gps, cincoPortas, cincoAssentos, duasBagagens));
        q3.setCategory(suv);
        q3.setCity(portoAlegre);
        q3.setImages(Set.of(q3Img));

        gle.setName("Mercedes-Benz GLE 5P");
        gle.setDescription("O Mercedes-Benz GLE é uma obra-prima automotiva que redefine o conceito de luxo, desempenho e inovação. Este SUV impressionante combina elegância contemporânea com tecnologia de ponta, proporcionando uma experiência de condução que ultrapassa os limites da excelência.");
        gle.setPrice("R$ 160,00");
        gle.setCategory(suv);
        gle.setFeatures(Set.of(cambioAutomatico, combustivelGasolina, kmIncluida300, gps, cincoPortas, cincoAssentos, duasBagagens));
        gle.setCity(sumare);
        gle.setImages(Set.of(gleImg));

        eClass.setName("Mercedes-Benz E-Class 5P");
        eClass.setDescription("E-Class é um carro...");
        eClass.setPrice("R$ 200,00");
        eClass.setCategory(luxury);
        eClass.setFeatures(Set.of(cambioAutomatico, combustivelGasolina, kmIncluida400, gps, cincoPortas, cincoAssentos, duasBagagens));
        eClass.setCity(saoPaulo);
        eClass.setImages(Set.of(eClassImg));

        bmw7.setName("BMW 7 Series 5P");
        bmw7.setDescription("O Mercedes-Benz E-Class é a personificação do luxo, elegância e inovação, oferecendo uma experiência de condução que transcende as expectativas. Este sedan de prestígio combina estilo clássico com tecnologia avançada, criando uma jornada excepcional em cada quilômetro percorrido.");
        bmw7.setPrice("R$ 200,00");
        eClass.setFeatures(Set.of(cambioAutomatico, combustivelGasolina, kmIncluida400, gps, cincoPortas, cincoAssentos, duasBagagens));
        bmw7.setCategory(luxury);
        bmw7.setCity(curitiba);
        bmw7.setImages(Set.of(bmw7Img));

        carrera.setName("Porsche 911 Carrera ");
        carrera.setDescription("O Porsche 911 Carrera é uma obra-prima automotiva que personifica a paixão pela condução esportiva e a herança lendária da marca. Este icônico carro esportivo combina design distinto com desempenho emocionante, oferecendo uma experiência de condução que eleva os sentidos.");
        carrera.setPrice("R$ 300,00");
        carrera.setFeatures(Set.of(cambioManual, combustivelGasolina, kmIncluida400, gps, duasPortas, doisAssentos, umaBagagem));
        carrera.setCategory(luxury);
        carrera.setCity(saoPaulo);
        carrera.setImages(Set.of(carreraImg));

        cayman.setName("Porsche Cayman");
        cayman.setDescription("O Porsche Cayman é uma expressão sublime de desempenho e elegância, oferecendo uma experiência de condução que combina a emoção esportiva com a sofisticação moderna. Este carro esportivo de dois lugares é um testemunho do compromisso da Porsche em criar veículos que transcender as expectativas.");
        cayman.setPrice("R$ 300,00");
        cayman.setFeatures(Set.of(cambioManual, combustivelGasolina, kmIncluida400, gps, duasPortas, doisAssentos, umaBagagem));
        cayman.setCategory(luxury);
        cayman.setCity(portoAlegre);
        cayman.setImages(Set.of(caymanImg));

        rroverSport.setName("Land Rover Range Rover Sport 5D");
        rroverSport.setDescription("O Land Rover Range Rover Sport é uma combinação única de luxo, desempenho e capacidade off-road, proporcionando uma experiência de condução que vai além dos limites tradicionais dos SUVs. Este veículo icônico representa o equilíbrio perfeito entre elegância urbana e capacidade todo-terreno.");
        rroverSport.setPrice("R$ 350,00");
        rroverSport.setFeatures(Set.of(cambioAutomatico, combustivelGasolina, kmIncluida400, gps, cincoPortas, cincoAssentos, duasBagagens));
        rroverSport.setCategory(luxury);
        rroverSport.setCity(sumare);
        rroverSport.setImages(Set.of(rroverSportImg));

        rroverJLR.setName("Land Rover Range Rover JLR");
        rroverJLR.setDescription("O Land Rover Range Rover JLR é o epítome do luxo automotivo, oferecendo uma experiência de condução que transcende as fronteiras da sofisticação. Este SUV de classe mundial combina um design elegante com um desempenho excepcional, proporcionando uma jornada repleta de conforto e prestígio.");
        rroverJLR.setPrice("R$ 300,00");
        rroverSport.setFeatures(Set.of(cambioAutomatico, combustivelGasolina, kmIncluida400, gps, cincoPortas, cincoAssentos, duasBagagens));
        rroverJLR.setCategory(luxury);
        rroverJLR.setCity(saoPaulo);
        rroverJLR.setImages(Set.of(rroverJLRImg));

        teslaY.setName("Tesla Y 4D");
        teslaY.setDescription("Tesla Y é um carro...");
        teslaY.setPrice("R$ 80,00");
        teslaY.setFeatures(Set.of(cambioAutomatico, combustivelEletrico, kmIncluida400, gps, kmCargaTotal300km, cabosCarregamento, cincoPortas, cincoAssentos, duasBagagens));
        teslaY.setCategory(eletric);
        teslaY.setCity(curitiba);
        teslaY.setImages(Set.of(teslaYImg));

        mbEqs.setName("Mercedes-Benz EQS 5D");
        mbEqs.setDescription("O Tesla Model Y é uma revolução no mundo dos veículos elétricos, combinando inovação, desempenho e sustentabilidade. Este SUV elétrico da Tesla redefine a mobilidade, oferecendo uma experiência de condução silenciosa, eficiente e totalmente livre de emissões.");
        mbEqs.setPrice("R$ 400,00");
        mbEqs.setFeatures(Set.of(cambioAutomatico, combustivelEletrico, kmIncluida400, gps, kmCargaTotal300km, cabosCarregamento, cincoPortas, cincoAssentos, duasBagagens));
        mbEqs.setCategory(eletric);
        mbEqs.setCity(portoAlegre);
        mbEqs.setImages(Set.of(mbEqsImg));

        bmwIx.setName("BMW IX 4P");
        bmwIx.setDescription("O BMW iX é a personificação da visão futurista da BMW, combinando design progressista, tecnologia avançada e desempenho sustentável. Este SUV elétrico representa o compromisso da BMW em oferecer uma experiência de condução premium que respeita o meio ambiente.");
        bmwIx.setPrice("R$ 300,00");
        bmwIx.setFeatures(Set.of(cambioAutomatico, combustivelEletrico, kmIncluida400, gps, kmCargaTotal300km, cabosCarregamento, cincoPortas, cincoAssentos, duasBagagens));
        bmwIx.setCategory(eletric);
        bmwIx.setCity(sumare);
        bmwIx.setImages(Set.of(bmwIxImg));

        zoe.setName("Renault Zoe 5D");
        zoe.setDescription("O Renault Zoe é um carro elétrico que combina estilo urbano, eficiência energética e tecnologia avançada, oferecendo uma alternativa sustentável para a mobilidade urbana. Este compacto elétrico da Renault é projetado para aqueles que buscam uma condução ecológica sem comprometer o conforto e a praticidade.");
        zoe.setPrice("R$ 50,00");
        zoe.setFeatures(Set.of(cambioAutomatico, combustivelEletrico, kmIncluida400, gps, kmCargaTotal300km, cabosCarregamento, cincoPortas, cincoAssentos, duasBagagens));
        zoe.setCategory(eletric);
        zoe.setCity(saoPaulo);
        zoe.setImages(Set.of(zoeImg));

        id4.setName("VW ID4 4P");
        id4.setDescription("O VW ID.4 é um veículo elétrico que encapsula a visão de mobilidade sustentável da Volkswagen, oferecendo um SUV compacto, eficiente e repleto de inovações tecnológicas. Este SUV elétrico redefine a experiência de condução, proporcionando uma alternativa ecológica para os amantes de carros");
        id4.setPrice("R$ 50,00");
        id4.setFeatures(Set.of(cambioAutomatico, combustivelEletrico, kmIncluida400, gps, kmCargaTotal300km, cabosCarregamento, cincoPortas, cincoAssentos, duasBagagens));
        id4.setCategory(eletric);
        id4.setCity(curitiba);
        id4.setImages(Set.of(poloImg));

        c4.setName("Citroen C4 5D");
        c4.setDescription("O Citroen C4, um hatchback que transcende a mera funcionalidade, é uma síntese magistral de elegância, conforto e desempenho em um pacote distintivo. Este modelo da Citroen não apenas define padrões, mas redefine a experiência de condução, fundindo um estilo moderno e cativante com funcionalidades inovadoras que inspiram cada viagem.");
        c4.setPrice("R$ 50,00");
        c4.setFeatures(Set.of(cambioAutomatico, combustivelEletrico, kmIncluida400, gps, kmCargaTotal300km, cabosCarregamento, cincoPortas, cincoAssentos, duasBagagens));
        c4.setCategory(eletric);
        c4.setCity(portoAlegre);
        c4.setImages(Set.of(c4Img));

        productRespository.saveAll(List.of(polo, clio, p308, a1, f500, picanto, tucson, captur, bmw1, tiguan, q3, gle, eClass, bmw7,
                carrera, cayman, rroverSport, rroverJLR, teslaY, mbEqs, bmwIx, zoe, id4, c4));


    //  ----------------------------------  USERS ----------------------------------------------------------------------------------


        User user = new User("Teste", "canario", "usuario@example.com", "123456", EnumRole.USER);

        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        userRepository.save(user);



        User userAdmin = new User("Admin", "adminAdmin", "usuarioAdmin@example.com", "123456", EnumRole.ADMIN);
        String rawPasswordAdmin = userAdmin.getPassword();
        String encodedPasswordAdmin = passwordEncoder.encode(rawPasswordAdmin);
        userAdmin.setPassword(encodedPasswordAdmin);
        userRepository.save(userAdmin);


        Booking activeBooking1 = new Booking();
        activeBooking1.setUser(user);
        activeBooking1.setCheckInTime("2024-01-01 12:00,");
        activeBooking1.setCheckOutTime("2024-01-03 10:00");
        activeBooking1.setProduct(teslaY);
        activeBooking1.setIsActive(true);
        bookingRepository.save(activeBooking1);

        Booking desactiveBooking2 = new Booking();
        desactiveBooking2.setUser(user);
        desactiveBooking2.setCheckInTime("2023-10-12 12:00,");
        desactiveBooking2.setCheckOutTime("2023-10-23 10:00");
        desactiveBooking2.setProduct(zoe);
        desactiveBooking2.setIsActive(false);
        bookingRepository.save(desactiveBooking2);


        Booking desactiveBooking3 = new Booking();
        desactiveBooking3.setUser(user);
        desactiveBooking3.setCheckInTime("2023-11-22 12:00,");
        desactiveBooking3.setCheckOutTime("2023-11-29 10:00");
        desactiveBooking3.setProduct(rroverSport);
        desactiveBooking3.setIsActive(false);
        bookingRepository.save(desactiveBooking3);



        //------------------------------------------------------------------------
    }
}